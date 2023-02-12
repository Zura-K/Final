package services;

import entities.Sales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.SalesRepository;

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
    public List<Sales> getSalesByDate(LocalDateTime sellDate) {
        return salesRepository.findBySellDate(sellDate);
    }
    @Override
    public Sales addSales(Sales sale) {
        return salesRepository.save(sale);
    }

}
