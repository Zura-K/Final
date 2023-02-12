package repositories;

import entities.Category;
import entities.Maker;
import entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository <Product, Integer>, JpaSpecificationExecutor<Product> {
    Optional<Product> findByENAcode(String enAcode);

    Optional<Product> findByMaker(Maker maker);

    Optional<Product> findByCategory(Category category);

    Optional<Product> findById(Integer id);
}
