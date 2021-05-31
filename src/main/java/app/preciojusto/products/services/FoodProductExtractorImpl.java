package app.preciojusto.products.services;

import app.preciojusto.products.DTOs.*;
import app.preciojusto.products.entities.*;
import app.preciojusto.products.exceptions.ApplicationExceptionCode;
import app.preciojusto.products.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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


            //Comprobamos si el producto existe ya en la base de datos
            //List<Product> listProductExists = this.productService.findAllByProdnameContaining(productRequest.getName());
            Optional<Product> productExists = this.productService.findProductByBrand_BrannameAndProdnameOrderByProdname(productRequest.getBrand(), productRequest.getName());

            Product product;
            if (productExists.isEmpty()) {
                //Create product
                FoodproductDTO foodproductDTO = new FoodproductDTO();
                Brand b = checkBrandExtract(productRequest);
                Category c = checkCategoryExtract(productRequest);
                Pack p = checkPackExtract(productRequest);
                Container co = checkContainerExtract(productRequest);

                foodproductDTO.setName(productRequest.getName());
                foodproductDTO.setBrandName(b.getBranname());
                foodproductDTO.setCategoryName(c.getCatename());

                if (p == null) {
                    foodproductDTO.setPackQuant(null);
                } else {
                    foodproductDTO.setPackQuant(p.getPackquantity());
                }

                if (co == null) {
                    foodproductDTO.setContainerId(null);
                } else {
                    foodproductDTO.setContainerId(co.getContid());
                }

                product = this.productService.saveFoodproductDTO(foodproductDTO);

                if (product == null) return false;
            } else {
                product = productExists.get();
            }

            FoodProduct foodProduct = this.productService.findProductByProdid(product.getProdid())
                    .orElseThrow(() -> new ResourceNotFoundException(ApplicationExceptionCode.PRODUCT_NOT_FOUND_ERROR));

            //Create supermarketproduct
            List<SupermarketProduct> registry = checkSupermarketProductExtract(foodProduct, productRequest.getSupermarketProducts());
            if (registry.size() != productRequest.getSupermarketProducts().size())
                return false;

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

        if (extractor.getContainer() == null) return null;
        String containerType = extractor.getContainer().getContainerType();
        Double containerCapacity = extractor.getContainer().getContainerQuantity();
        String containerUnit = extractor.getContainer().getContainerUnit();

        Container container;
        try {
            container = this.containerService.findContainerByContcapacityAndAndConttypeAndContunit(containerCapacity, containerType, containerUnit)
                    .orElseThrow(() -> new ResourceNotFoundException(ApplicationExceptionCode.CONTAINER_NOT_FOUND_ERROR));
        } catch (Exception e) {
            container = null;
        }

        if (container == null) {
            Container co = new Container();
            co.setContunit(containerUnit);
            co.setConttype(containerType);
            co.setContcapacity(containerCapacity);
            container = this.containerService.save(co);
        }

        return container;
    }

    @Override
    public Offer checkOfferExtract(OfferExtractorRequestDTO extractor) {

        //Si no hay oferta, devolveremos null
        if (extractor == null || extractor.getOffer_type() == null) return null;

        Offer offer;
        switch (extractor.getOffer_type()) {
            case "offerpercentage":
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
    public List<SupermarketProduct> checkSupermarketProductExtract(FoodProduct foodProduct, List<SupermarketProductsExtractorRequestDTO> extractor) {

        List<SupermarketProduct> registry = new ArrayList<>();
        for (SupermarketProductsExtractorRequestDTO supeprod : extractor) {

            //Create/get supermarket
            Supermarket supermarket = this.checkSupermarketExtract(supeprod);

            //Create/get offer
            Offer offer = checkOfferExtract(supeprod.getOffer());

            //Create/get supermarketproduct
            if (this.supermarketProductService.findById(new SupermarketProductCK(foodProduct.getProdid(), supermarket.getSupeid())).isPresent()) {
                SupermarketProduct supermarketProduct = this.supermarketProductService.findById(new SupermarketProductCK(foodProduct.getProdid(), supermarket.getSupeid())).get();

                supermarketProduct.setOffer(offer);
                supermarketProduct.setSuprprice(supeprod.getPrice());
                supermarketProduct.setSuprlastupdated(LocalDateTime.now());
                supermarketProduct.setSuprimg(supeprod.getImg());
                supermarketProduct.setSuprstock(supeprod.getStock());
                registry.add(this.supermarketProductService.save(supermarketProduct));

            } else {
                SupermarketProductDTO supermarketProductDTO = new SupermarketProductDTO();
                supermarketProductDTO.setProductid(foodProduct.getProdid());
                supermarketProductDTO.setSuperid(supermarket.getSupeid());
                supermarketProductDTO.setImg(supeprod.getImg());
                if (offer != null) {
                    supermarketProductDTO.setOfferid(offer.getOffeid());
                }
                supermarketProductDTO.setStock(supeprod.getStock());
                registry.add(this.supermarketProductService.add(supermarketProductDTO));
            }
        }

        return registry;
    }
}
