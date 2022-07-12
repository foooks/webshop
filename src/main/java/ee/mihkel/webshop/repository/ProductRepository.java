package ee.mihkel.webshop.repository;

import ee.mihkel.webshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> getAllByOrderByIdAsc();
//    List<Product> findAllByasActiveOrderByIdAsc(boolean active);
//    List<Product> findAllByasActiveAAndStockOrderByIdAsc(boolean active, int stockNot);
    List<Product> findAllByStockGreaterThanAndAndAsActiveEqualsOrderByIdAsc(int stock, boolean active);
}
