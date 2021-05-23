package app.preciojusto.products.services;

import app.preciojusto.products.DTOs.ExtractorFoodproductDTO;
import app.preciojusto.products.entities.*;
import app.preciojusto.products.exceptions.ResourceNotFoundException;
import net.bytebuddy.implementation.bind.annotation.Super;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            Brand b = checkBrandExtract(productRequest);
            Category c = checkCategoryExtract(productRequest);
            Pack p = checkPackExtract(productRequest);
            Supermarket s = checkSupermarketExtract(productRequest);
            Container co = new Container();
            co.setConttype("lata");
            co.setContunit("cl");
            co.setContcapacity(33.0);

            //Create relationship with supermarket product
            //SupermarketProduct supermarketProduct = this.supermarketProductService.save()

            Product productAdded = this.productService.saveFoodProduct(null, productRequest.getName(), b.getBranname(), c.getCatename(), s.getSupename(), co, p);

            if (productAdded == null) return false;

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
            brand = this.brandService.findByBrannameEquals(brandname);
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
        String catename = extractor.getCategoryName();

        Category category;
        try {
            category = this.categoryService.findByCatenameEquals(catename);
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
        if(packnumber == null) return null;

        Pack pack;
        try {
            pack = this.packService.findByPackquantity(packnumber);
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
    public Supermarket checkSupermarketExtract(ExtractorFoodproductDTO extractor) {
        String supename = extractor.getSupermarketName();

        Supermarket supermarket;
        try {
            supermarket = this.supermarketService.findBySupenameEquals(supename);
        } catch (Exception e) {
            supermarket = null;
        }


        if (supermarket == null) {
            //Supermarket s = new Supermarket();
            //s.setSupename(supename);
            supermarket = this.supermarketService.save(null, supename);
        }
        return supermarket;
    }

    @Override
    public Container checkContainerExtract(ExtractorFoodproductDTO extractor) {
        return null;
    }

    @Override
    public Offer checkOfferExtract(ExtractorFoodproductDTO extractor) {
        //String offer_type = extractor.getOffer_type();
        //if(offer_type == null) return null;

        /*
        Offer offer;
        try {

            if (offer_type.contains("%")) offer = this.offerService.
            offer = this.offerService.findOfferById();
        } catch (Exception e) {
            offer = null;
        }

        if (offer == null) {
            Pack p = new Pack();
            p.setPackquantity(packnumber);
            offer = this.packService.save(p);
        }
*/
        return null;
    }
}
