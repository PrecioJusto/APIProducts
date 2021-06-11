package app.preciojusto.products.repositories;

import app.preciojusto.products.entities.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT DISTINCT * FROM product p INNER JOIN supermarketproduct s ON p.prodid = s.prodid INNER JOIN offerpercentage o ON s.offeid = o.offeid WHERE s.offeid IS NOT NULL ORDER BY o.ofpepercentage DESC;",
            nativeQuery = true)
    List<Product> findAllProductWithOffer(Pageable page);


    List<Product> findAllByProdcreatedtimeIsNotNullOrderByProdviewsDesc(Pageable pageable);

    Optional<Product> findProductByProdnameContaining(String name);

    List<Product> findAllByProdnameContaining(String name);

    List<Product> findAllByCategory_Catename(String name);

    Optional<Product> findProductByBrand_BrannameAndProdnameOrderByProdname(String branname, String prodname);
}
