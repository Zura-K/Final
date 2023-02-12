package entities;

import javax.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Data
@SequenceGenerator(name = "purchasesIdGenerator", sequenceName = "purchasesIdGenerator", allocationSize = 1)
@Table(name="purchases")
public class Purchases {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "purchasesIdGenerator")
    @Id
    private Integer id;

    @OneToOne
    @JoinColumn(name="product_id")
    private Product productId;

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
