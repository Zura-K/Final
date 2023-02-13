package main.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Data
@SequenceGenerator(name = "purchasesIdGenerator", sequenceName = "purchasesIdGenerator", allocationSize = 1)
@Table(name="purchases")
public class Purchases {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "purchasesIdGenerator")
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name="product_id")
    private String productId;

    @Column(name = "purchase_price", nullable = false)
    private Double purchasePrice;

    @Column(name = "purchase_quantity", nullable = false)
    private Integer purchaseQuantity;

    @Column(name = "total_purchase_price", nullable = false)
    private Double totalPurchasePrice;

    @Column(name = "purchase_date", nullable = false)
    private LocalDateTime purchaseDate;

    @PrePersist
    public void prePersist(){
        purchaseDate = LocalDateTime.now();
    }
}
