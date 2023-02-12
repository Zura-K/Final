package services;

import entities.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product createProduct(Product products);

    Product getProduct(String ENACode);

    void sellProduct(String ENACode, Double price, Long bundle);

    void purchaseProduct(Long id);

    void registerSale (String ENACode, Double sellPrice, Long sellQuantity, Double totalSellPrice);

}
