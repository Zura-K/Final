package services;

import entities.Purchases;

import java.util.List;

public interface PurchaseService {
    List<Purchases> getAllPurchases();

    Purchases getPurchaseById(Integer id);

    Purchases addPurchase(Purchases purchase);
}
