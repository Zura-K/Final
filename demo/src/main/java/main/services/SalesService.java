package main.services;

import main.entities.Sales;

import java.time.LocalDateTime;
import java.util.List;

public interface SalesService {

    Sales addSales(Sales sale);

    List<Sales> getAllSales();

    List<Sales> getSalesByDate(LocalDateTime startDate, LocalDateTime endDate);

}
