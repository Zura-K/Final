package services;

import entities.Purchases;
import exceptions.NotFoundException;
import org.springframework.stereotype.Service;
import repositories.PurchasesRepository;

import java.util.List;

@Service
public class PurchaseServiceImplementation implements PurchaseService{

    PurchasesRepository purchasesRepository;

    @Override
    public List<Purchases> getAllPurchases() {
        return purchasesRepository.findAll();
    }

    @Override
    public Purchases getPurchaseById(Integer id) {
        return purchasesRepository.findById(id).orElseThrow (() -> new NotFoundException("Product not found"));
    }

    @Override
    public Purchases addPurchase(Purchases purchase) {
        return purchasesRepository.save(purchase);
    }
}
