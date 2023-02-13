package main.controller;


import main.config.UserCredentials;
import main.entities.Purchases;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import main.services.PurchaseServiceImplementation;

import java.util.List;

@RestController
@RequestMapping("/purchases")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ROLE_Manager')")
public class PurchasesController {

    private final PurchaseServiceImplementation purchaseService;

    @GetMapping
    public List<Purchases> getAllPurchases() {
        return purchaseService.getAllPurchases();
    }

    @GetMapping("/{id}")
    public Purchases getPurchaseById(@PathVariable Integer id) {
        return purchaseService.getPurchaseById(id);
    }

    @PostMapping
    public Purchases addPurchase(@RequestBody Purchases purchase, String productId, @AuthenticationPrincipal UserCredentials user) {
        return purchaseService.addPurchase(purchase, productId, user);
    }
}