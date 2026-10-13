package uk.ac.westminster.products_api;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServive {
    private List<Product> products = new  ArrayList<>();
    private Long nextId = 1l; //This remembers which id to hand out next

    public List<Product> getAllProducts() {
        return products;
    }

    public Product addProduct (Product product) {
        prodcut.setId(nextId++);
        products.add(product);
        return product;
    }
}
