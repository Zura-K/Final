package main.services;

import main.entities.Sales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import main.repositories.SalesRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SalesServiceImplementation implements SalesService {

    private final SalesRepository salesRepository;

    @Autowired
    public SalesServiceImplementation(SalesRepository salesRepository){
        this.salesRepository = salesRepository;
    }

    @Override
    public List<Sales> getAllSales() {
        return salesRepository.findAll();
    }

    @Override
    public List<Sales> getSalesByDate(LocalDateTime startDate, LocalDateTime endDate) {
        return salesRepository.findBySellDateBetween(startDate, endDate);
    }

    //რეალურად გაყიდვის რეგისტრაცია უკვე შევქმენი პროდუქტების იმპლემენტაციაში, ასე რომ მგონი ეს არცაა საჭირო;
    @Override
    public Sales addSales(Sales sale) {
        return salesRepository.save(sale);
    }

}
