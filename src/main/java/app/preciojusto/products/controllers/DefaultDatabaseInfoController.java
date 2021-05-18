package app.preciojusto.products.controllers;

import app.preciojusto.products.DTOs.FoodproductDTO;
import app.preciojusto.products.DTOs.SupermarketProductDTO;
import app.preciojusto.products.entities.*;
import app.preciojusto.products.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class DefaultDatabaseInfoController {

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
    private OfferService offerService;

    @Autowired
    private SupermarketProductService supermarketProductService;

    @Autowired
    private RecipeService recipeService;

    @GetMapping("/addDefaultInfo")
    public Boolean addDefaultInfo() {
        try {

            Brand b = new Brand();
            b.setBranname("coca");
            this.brandService.save(b);

            Category ca1 = new Category();
            ca1.setCatename("refrescos");
            Category ca2 = new Category();
            ca2.setCatename("bebidas");
            this.categoryService.save(ca1);
            this.categoryService.save(ca2);


            Container c = new Container();
            c.setConttype("lata");
            c.setContunit("cl");
            c.setContcapacity(33.0);
            this.containerService.save(c);

            Pack p = new Pack();
            p.setPackquantity(24);
            this.packService.save(p);

            Supermarket s = new Supermarket();
            s.setSupename("carrefour");
            this.supermarketService.save(s);

            this.categoryService.setAsChildren("refrescos", "bebidas");

            Offer offer = this.offerService.saveOfferPercentage(null, 20, 3.0);

            FoodproductDTO foodproductDTO = new FoodproductDTO();
            foodproductDTO.setBrandName("coca");
            foodproductDTO.setContainerId(1L);
            foodproductDTO.setName("Coca Cola zero azúcar pack 24 latas 33 cl.");
            foodproductDTO.setCategoryName("refrescos");
            foodproductDTO.setPackQuant(24);

            Product finalp = this.productService.saveFoodproductDTO(foodproductDTO);

            LocalDateTime now = LocalDateTime.now();
            SupermarketProductDTO supermarketProductDTO = new SupermarketProductDTO();
            supermarketProductDTO.setSuperid(1L);
            supermarketProductDTO.setStock(true);
            supermarketProductDTO.setPrice(3);
            supermarketProductDTO.setProductid(finalp.getProdid());
            supermarketProductDTO.setOfferid(null);

            this.supermarketProductService.add(supermarketProductDTO);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
