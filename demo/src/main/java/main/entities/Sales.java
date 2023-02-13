package main.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@SequenceGenerator(name = "salesIdGenerator", sequenceName = "salesIdGenerator", allocationSize = 1)
@Table(name="sales")
public class Sales {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "salesIdGenerator")
    @Id
    @Column(name = "id")
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
