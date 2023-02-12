package entities;

import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
@SequenceGenerator(name = "salesIdGenerator", sequenceName = "salesIdGenerator", allocationSize = 1)
@Table(name="sales")
public class Sales {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "salesIdGenerator")
    @Id
    private Integer id;

    @JoinColumn(name="product_id")
    private String ENACode;

    @Column(name = "sell_price", nullable = false)
    private double sellPrice;

    @Column(name = "sell_quantity", nullable = false)
    private Long sellQuantity;

    @Column(name = "total_sell_price", nullable = false)
    private Double totalSellPrice;


    @Column(name = "sell_date", nullable = false)
    private LocalDateTime sellDate;

    @PrePersist
    public void prePersist(){
        sellDate = LocalDateTime.now();
    }
}
