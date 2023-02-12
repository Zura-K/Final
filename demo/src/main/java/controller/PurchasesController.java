package controller;


import entities.Purchases;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import services.PurchaseService;

import java.util.List;

@RestController
@RequestMapping("/purchases")
@RequiredArgsConstructor
public class PurchasesController {

    private final PurchaseService purchaseService;

    @GetMapping
    public List<Purchases> getAllPurchases() {
        return purchaseService.getAllPurchases();
    }

    @GetMapping("/{id}")
    public Purchases getPurchaseById(@PathVariable Integer id) {
        return purchaseService.getPurchaseById(id);
    }

    @PostMapping
    public Purchases addPurchase(@RequestBody Purchases purchase) {
        return purchaseService.addPurchase(purchase);
    }
}