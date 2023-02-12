package repositories;

import entities.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SalesRepository extends JpaRepository<Sales,Integer> {
    List<Sales> findBySellDate(LocalDateTime sellDate);
}
