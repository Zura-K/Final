package main.services;

import main.entities.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    ResponseEntity<Product> createProduct(Product products);

    Product getProduct(String eanCode);

    void sellProduct(String eanCode, Double price, Long bundle);

    void purchaseProduct(Integer id);

    void registerSale (String ENACode, Double sellPrice, Long sellQuantity, Double totalSellPrice);

}
