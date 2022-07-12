package ee.mihkel.webshop.controller;

import ee.mihkel.webshop.cache.ProductCache;
import ee.mihkel.webshop.exceptions.ProductNotFoundException;
import ee.mihkel.webshop.model.Product;
import ee.mihkel.webshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.ExecutionException;

@CrossOrigin("http://localhost:3000")
@RestController
public class ProductController {
//    List<Product> products = new ArrayList<>();

    @Autowired
    ProductCache productCache;

    @Autowired
    ProductRepository productRepository;

    @GetMapping ("products")        // GET
    public List <Product> getProducts() {
        return productRepository.getAllByOrderByIdAsc();
    }
    @GetMapping ("active-products")        // GET
    public List <Product> getActiveProducts() {
        return productRepository.findAllByStockGreaterThanAndAndAsActiveEqualsOrderByIdAsc(0 ,true);
    }
    @PostMapping("products")
    public void addProducts(@RequestBody Product product) {  // POST
        // products.add(product);
        productRepository.save(product);
    }
    @DeleteMapping("products/{id}")
    public List<Product> deleteProduct(@PathVariable Long id){
        productRepository.deleteById(id);
        return productRepository.findAll();
    }
    @PutMapping ("products")
    public void editProduct(@RequestBody Product product){
        if (productRepository.findById(product.getId()).isPresent()){
            productRepository.save(product);
        }
    }


        @GetMapping ("products/{id}")        //localhost.8080/products/1 GET
        public Product getProduct(@PathVariable Long id) throws ProductNotFoundException {

            //Optional <Product> ---> tagasta kas product voi null
 //           return productRepository.findById(id).get();
            try {
                return productCache.getProduct(id);
            }catch (Exception e) {
                throw new ProductNotFoundException();
            }
            //productRepository.findById(id).get(); --> tagasta product voi Error
        }

    //muutmine
    @PatchMapping("decrease-stock")
    public List<Product> decreaceStock(@RequestBody Product product) {
        if (product.getStock() > 0) {
            int newStock = product.getStock() - 1;
            product.setStock(newStock);
            productRepository.save(product);
        }
        return productRepository.getAllByOrderByIdAsc();
    }

    @PatchMapping("increase-stock")
    public List<Product> increaceStock(@RequestBody Product product) {
        int newStock = product.getStock() + 1;
        product.setStock(newStock);
        productRepository.save(product);
        return productRepository.getAllByOrderByIdAsc();
    }


}
