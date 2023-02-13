package main.services;

import main.config.UserCredentials;
import main.entities.Purchases;
import main.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import main.repositories.ProductRepository;
import main.repositories.PurchasesRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PurchaseServiceImplementation implements PurchaseService{

    private final PurchasesRepository purchasesRepository;
    private final ProductRepository productRepository;

    @Override
    public List<Purchases> getAllPurchases() {
        return purchasesRepository.findAll();
    }

    @Override
    public Purchases getPurchaseById(Integer id) {
        return purchasesRepository.findById(id).orElseThrow (() -> new NotFoundException("Product not found"));
    }

    @Override
    public Purchases addPurchase(Purchases purchase, String eanCode, UserCredentials user) {
        var product = productRepository.findByEanCode(eanCode).orElseThrow(() -> new NotFoundException("Product Id Does not Exist"));
        purchase.setProductId(eanCode);
        product.setQuantity(product.getQuantity() + purchase.getPurchaseQuantity());

        return purchasesRepository.save(purchase);
    }
}
