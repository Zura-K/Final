package main.services;

import main.entities.Product;
import main.entities.Sales;
import main.exceptions.NotFoundException;
import main.repositories.ProductRepository;
import main.repositories.SalesRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

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
    public ResponseEntity<Product> createProduct(Product product) {
        product.setEanCode(Product.GenerateEAN.generate13DigitString());
        var productID = productRepository.findByEanCode(product.getEanCode());
        if(productID.isPresent()){
            product.setEanCode(Product.GenerateEAN.generate13DigitString());
        }
        productRepository.save(product);
        var location = UriComponentsBuilder.fromPath("/products").buildAndExpand(product.getEanCode()).toUri();
        return ResponseEntity.created(location).body(product);
    }

    @Override
    public Product getProduct(String ENACode) {
        return productRepository.findByEanCode(ENACode).orElseThrow (() -> new NotFoundException("Product not found"));

    }

    @Override
    public void sellProduct(String ENACode, Double price, Long bundle) {
        Product product = productRepository.findByEanCode(ENACode).orElse(null);
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
    public void purchaseProduct(Integer id) {

    }
}
