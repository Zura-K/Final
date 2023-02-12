package entities;

import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@SequenceGenerator(name = "productIdGenerator", sequenceName = "productIdGenerator", allocationSize = 1)
@Table(name="products")
public class Product {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productIdGenerator")
    @Id
    private Integer id;

    @Column(name = "EANcode", nullable = false, length = 13)
    private String EANcode;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "description", nullable = false)
    private String description;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="maker_id")
    private Maker maker;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="category_id")
    private Category category;

    @Column(name = "sell_price", nullable = false)
    private double sellPrice;

    @Column(name = "quantity", nullable = false)
    private Long quantity;

    public void setENACode(String s) {
    }

    public void setPrice(double v) {
    }

    public void setBundle(long l) {
    }
}
