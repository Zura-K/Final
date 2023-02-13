package main.controller;

import main.entities.Sales;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import main.services.SalesServiceImplementation;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/sales")
@PreAuthorize("hasRole('ROLE_Manager') or hasRole('ROLE_Salesman')" )
@RequiredArgsConstructor
public class SalesController {

    private final SalesServiceImplementation salesService;

    @GetMapping
    public List<Sales> findSalesByDate(LocalDateTime startDate, LocalDateTime endDate) {
        return salesService.getSalesByDate(startDate,endDate);
    }

    @GetMapping("/all")
    public List<Sales> getAllSales() {
        return salesService.getAllSales();
    }

    @PostMapping
    public Sales createSales(@RequestBody Sales sales) {
        return salesService.addSales(sales);
    }

}