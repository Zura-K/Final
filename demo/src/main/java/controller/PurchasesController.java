package controller;


import entities.Purchases;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchases")
public class PurchasesController {

    @GetMapping
    public List<Purchases> getAllPurchases() {
        // Implementation to retrieve all purchases from database
        return null;
    }

    @GetMapping("/{id}")
    public Purchases getPurchaseById(@PathVariable Integer id) {
        // Implementation to retrieve purchase by id from database
        return null;
    }

    @PostMapping
    public Purchases addPurchase(@RequestBody Purchases purchase) {
        // Implementation to add a new purchase
        return null;
    }
}