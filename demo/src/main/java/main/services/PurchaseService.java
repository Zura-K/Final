package main.services;

import main.config.UserCredentials;
import main.entities.Purchases;

import java.util.List;

public interface PurchaseService {
    List<Purchases> getAllPurchases();

    Purchases getPurchaseById(Integer id);

    Purchases addPurchase(Purchases purchase, String eanCode, UserCredentials user);
}
