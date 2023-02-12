package controller;

import entities.Sales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.SalesService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/sales")
public class SalesController {

    private final SalesService salesService;

    public SalesController(SalesService salesService) {
        this.salesService = salesService;
    }

    @GetMapping
    public List<Sales> findSalesByDate(LocalDateTime sellDate) {
        return salesService.getSalesByDate(sellDate);
    }

    @GetMapping
    public List<Sales> getAllSales() {
        return salesService.getAllSales();
    }

    @PostMapping
    public Sales createSales(@RequestBody Sales sales) {
        return salesService.addSales(sales);
    }

}