package app.preciojusto.products.services;

import app.preciojusto.products.DTOs.*;
import app.preciojusto.products.entities.*;
import app.preciojusto.products.exceptions.ApplicationExceptionCode;
import app.preciojusto.products.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodProductExtractorImpl implements FoodProductExtractorService {

    @Autowired
    private BrandService brandService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @Autowired
    private PackService packService;

    @Autowired
    private ContainerService containerService;

    @Autowired
    private SupermarketService supermarketService;

    @Autowired
    OfferService offerService;

    @Autowired
    private SupermarketProductService supermarketProductService;

    @Autowired
    private RecipeService recipeService;


    @Override
    public Boolean checkGlobalExtract(ExtractorFoodproductDTO productRequest) {

        try {

            //Create product
            FoodproductDTO foodproductDTO = new FoodproductDTO();
            Brand b = checkBrandExtract(productRequest);
            Category c = checkCategoryExtract(productRequest);
            Pack p = checkPackExtract(productRequest);
            Container co = checkContainerExtract(productRequest);
            //co.setConttype("lata");
            //co.setContunit("cl");
            //co.setContcapacity(33.0);

            //private String name;
            //private String brandName;
            //private String categoryName;
            //private Long containerId;
            //private Integer packQuant;

            foodproductDTO.setName(productRequest.getName());
            foodproductDTO.setBrandName(b.getBranname());
            foodproductDTO.setCategoryName(c.getCatename());
            foodproductDTO.setContainerId(null);

            if (p == null) {
                foodproductDTO.setPackQuant(null);
            } else {
                foodproductDTO.setPackQuant(p.getPackquantity());
            }

            Product productAdded = this.productService.saveFoodproductDTO(foodproductDTO);

            if (productAdded == null) return false;

            FoodProduct foodProduct = this.productService.findProductByProdid(productAdded.getProdid())
                    .orElseThrow(() -> new ResourceNotFoundException(ApplicationExceptionCode.PRODUCT_NOT_FOUND_ERROR));

            //Create supermarketproduct
            List<SupermarketProductDTO> addedSupermarketProducts = checkSupermarketProductExtract(foodProduct, productRequest.getSupermarketProducts());
            if (addedSupermarketProducts.size() != productRequest.getSupermarketProducts().size())
                return null;

        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Brand checkBrandExtract(ExtractorFoodproductDTO extractor) throws ResourceNotFoundException {
        String brandname = extractor.getBrand();

        Brand brand;
        try {

            brand = this.brandService.findByBrannameEquals(brandname)
                    .orElseThrow(() -> new ResourceNotFoundException(ApplicationExceptionCode.BRAND_NOT_FOUND_ERROR));
        } catch (Exception e) {
            brand = null;
        }


        if (brand == null) {
            Brand b = new Brand();
            b.setBranname(brandname);
            brand = this.brandService.save(b);
        }

        return brand;
    }

    @Override
    public Category checkCategoryExtract(ExtractorFoodproductDTO extractor) throws Exception {
        String catename = extractor.getCategory();

        Category category;
        try {
            category = this.categoryService.findByCatenameEquals(catename)
                    .orElseThrow(() -> new ResourceNotFoundException(ApplicationExceptionCode.CATEGORY_NOT_FOUND_ERROR));
        } catch (Exception e) {
            category = null;
        }


        if (category == null) {
            Category c = new Category();
            c.setCatename(catename);
            category = this.categoryService.save(c);
        }

        return category;
    }

    @Override
    public Pack checkPackExtract(ExtractorFoodproductDTO extractor) throws ResourceNotFoundException {
        Integer packnumber = extractor.getPack();

        if (packnumber == null) return null;

        Pack pack;
        try {
            pack = this.packService.findByPackquantity(packnumber)
                    .orElseThrow(() -> new ResourceNotFoundException(ApplicationExceptionCode.PACK_NOT_FOUND_ERROR));
        } catch (Exception e) {
            pack = null;
        }

        if (pack == null) {
            Pack p = new Pack();
            p.setPackquantity(packnumber);
            pack = this.packService.save(p);
        }

        return pack;
    }

    @Override
    public Supermarket checkSupermarketExtract(SupermarketProductsExtractorRequestDTO extractor) {

        String supename = extractor.getSupermarket();

        Supermarket supermarket;
        try {
            supermarket = this.supermarketService.findBySupenameEquals(supename)
                    .orElseThrow(() -> new ResourceNotFoundException(ApplicationExceptionCode.SUPERMARKET_NOT_FOUND_ERROR));
        } catch (Exception e) {
            supermarket = null;
        }


        if (supermarket == null) {
            Supermarket s = new Supermarket();
            s.setSupename(supename);
            supermarket = this.supermarketService.save(s);
        }

        return supermarket;
    }

    @Override
    public Container checkContainerExtract(ExtractorFoodproductDTO extractor) {
        String containerType = extractor.getContainer().getContainerType();

        /*
        Container container;
        try {
            container = this.containerService.findByCatenameEquals(catename)
                    .orElseThrow(() -> new ResourceNotFoundException(ApplicationExceptionCode.CATEGORY_NOT_FOUND_ERROR));
        } catch (Exception e) {
            category = null;
        }


        if (category == null) {
            Category c = new Category();
            c.setCatename(catename);
            category = this.categoryService.save(c);
        }
         */

        return null;
    }

    @Override
    public Offer checkOfferExtract(OfferExtractorRequestDTO extractor) {

        String offer_type = extractor.getOffer_type();
        if (offer_type == null) return null;

        Offer offer;
        switch (offer_type) {
            case "offerpercentage":
                // code block
                OfferPercentage offerPercentage = new OfferPercentage();
                offerPercentage.setOfpepercentage(extractor.getOfpepercentage());
                offerPercentage.setOfpepreviousprice(extractor.getOfpepreviousprice());
                offer = this.offerService.saveOfferPercentage(offerPercentage);
                break;
            case "offerunit":
                OfferUnit offerUnit = new OfferUnit();
                offerUnit.setOfunfirst(extractor.getOfunfirst());
                offerUnit.setOfunsecond(extractor.getOfunsecond());
                offer = this.offerService.saveOfferUnit(offerUnit);
                break;
            case "offerunitpercentage":
                OfferUnitPercentage offerUnitPercentage = new OfferUnitPercentage();
                offerUnitPercentage.setOfuppercentage(extractor.getOfuppercentage());
                offerUnitPercentage.setOfupunitaffected(extractor.getOfupunitaffected());
                offer = this.offerService.saveOfferUnitPercentage(offerUnitPercentage);
                break;
            case "offerunitplainprice":
                OfferUnitPlainPrice offerUnitPlainPrice = new OfferUnitPlainPrice();
                offerUnitPlainPrice.setOfupprice(extractor.getOfupprice());
                offerUnitPlainPrice.setOfupunits(extractor.getOfupunits());
                offer = this.offerService.saveOfferUnitPlainPrice(offerUnitPlainPrice);
                break;
            default:
                OfferUnknown offerUnknownDefault = new OfferUnknown();
                offerUnknownDefault.setOfunname(extractor.getOfunname());
                offer = this.offerService.saveOfferUnknown(offerUnknownDefault);
        }
        return offer;
    }

    @Override
    public List<SupermarketProductDTO> checkSupermarketProductExtract(FoodProduct foodProduct, List<SupermarketProductsExtractorRequestDTO> extractor) {

        List<SupermarketProductDTO> supermarketProducts = new ArrayList<>();
        for (SupermarketProductsExtractorRequestDTO supeprod : extractor) {

            //Sacamos el supermarket
            Supermarket supermarket = this.checkSupermarketExtract(supeprod);

            //Sacamos el offer
            Offer offer = checkOfferExtract(supeprod.getOffer());

            //Creamos el supermarketproduct


            //SupermarketProduct supermarketProduct = new SupermarketProduct();
            //supermarketProduct.setProdid(foodProduct);
            //supermarketProduct.setSupeid(supermarket);
            //supermarketProduct.setSuprimg(supeprod.getImg());
            //supermarketProduct.setOffer(offer);
            //supermarketProduct.setSuprlastupdated(LocalDateTime.now());
            //supermarketProduct.setSuprstock(supeprod.getStock());
            //supermarketProducts.add(supermarketProduct);

            SupermarketProductDTO supermarketProductDTO = new SupermarketProductDTO();
            supermarketProductDTO.setProductid(foodProduct.getProdid());
            supermarketProductDTO.setSuperid(supermarket.getSupeid());
            supermarketProductDTO.setImg(supeprod.getImg());
            supermarketProductDTO.setOfferid(offer.getOffeid());
            supermarketProductDTO.setStock(supeprod.getStock());
            supermarketProducts.add(supermarketProductDTO);
        }

        return supermarketProducts;
    }
}
