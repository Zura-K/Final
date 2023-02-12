package services;

import dto.ProductSearchParams;
import entities.Category;
import entities.Maker;
import entities.Product;
import entities.Sales;
import exceptions.ShopExceptions;
import repositories.*;

import java.time.LocalDateTime;
import java.util.List;

public class ProductServiceImplementation implements ProductService{

    private final CategoryRepository categoryRepository;
    private final MakerRepository makerRepository;
    private final ProductRepository productRepository;
    private final PurchasesRepository purchasesRepository;
    private final SalesRepository salesRepository;

    private final ProductService productService;

    public ProductServiceImplementation(CategoryRepository categoryRepository, MakerRepository makerRepository, ProductRepository productRepository, PurchasesRepository purchasesRepository, SalesRepository salesRepository, ProductService productService) {
        this.categoryRepository = categoryRepository;
        this.makerRepository = makerRepository;
        this.productRepository = productRepository;
        this.purchasesRepository = purchasesRepository;
        this.salesRepository = salesRepository;
        this.productService = productService;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product createProduct(Product products) {
        return productRepository.save(products);
    }

    @Override
    public Product getProduct(String ENACode) {
        Product product = productRepository.findByENAcode(ENACode).orElse(null);

        return product;
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
