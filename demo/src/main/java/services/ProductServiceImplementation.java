package services;

import entities.Product;
import entities.Sales;
import exceptions.NotFoundException;
import org.springframework.stereotype.Service;
import repositories.*;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductServiceImplementation implements ProductService{

    private final ProductRepository productRepository;
    private final SalesRepository salesRepository;

    public ProductServiceImplementation(ProductRepository productRepository, SalesRepository salesRepository) {
        this.productRepository = productRepository;
        this.salesRepository = salesRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(Product products) {
        return productRepository.save(products);
    }

    @Override
    public Product getProduct(String ENACode) {
        return productRepository.findByENAcode(ENACode).orElseThrow (() -> new NotFoundException("Product not found"));

    }

    @Override
    public void sellProduct(String ENACode, Double price, Long bundle) {
        Product product = productRepository.findByENAcode(ENACode).orElse(null);
        price = product.getSellPrice();
        Double totalPrice = bundle*price;

        product.setQuantity(product.getQuantity()-bundle);
        productRepository.save(product);

        registerSale(ENACode, price, bundle, totalPrice);
    }

    @Override
    public void registerSale(String ENACode, Double sellPrice, Long sellQuantity, Double totalSellPrice) {
        Sales sale = new Sales();
        sale.setENACode(ENACode);
        sale.setSellPrice(sellPrice);
        sale.setSellQuantity(sellQuantity);
        sale.setTotalSellPrice(totalSellPrice);
        sale.setSellDate(LocalDateTime.now());
        salesRepository.save(sale);
    }

    @Override
    public void purchaseProduct(Long id) {

    }
}
