package services;

import entities.Sales;
import net.bytebuddy.asm.Advice;

import java.time.LocalDateTime;
import java.util.List;

public interface SalesService {

    Sales addSales(Sales sale);

    List<Sales> getAllSales();

    List<Sales> getSalesByDate(LocalDateTime sellDate);

}
