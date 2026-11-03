package uk.ac.westminster.products_api;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();
    private Long nextId = 1L;
    public ProductService() {
// Both subclasses go into ONE List<Product>.
// No cast is needed because each IS-A Product.
        products.add(new DigitalProduct(
                nextId++, "Clean Code (E-book)", 29.99,
                "/downloads/clean-code.pdf", 4.2));
        products.add(new PhysicalProduct(
                nextId++, "27-inch Monitor", 249.99,5.4, "61cm x 41cm x 18cm"));
    }
    // --- unchanged from Tutorial 3 ---
    public List<Product> getAllProducts() {
        return products;
    }
    public Optional<Product> getProductById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }
    public Product addProduct(Product product) {
        product.setId(nextId++);
        products.add(product);
        return product;
    }
    public void deleteProduct(Long id) {
        products.removeIf(p -> p.getId().equals(id));
    }
}