package main.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Random;

@Entity
@Data
@NoArgsConstructor
@SequenceGenerator(name = "productIdGenerator", sequenceName = "productIdGenerator", allocationSize = 1)
@Table(name="products")
public class Product {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productIdGenerator")
    @Id
    @Column(name="id")
    private Integer id;

    @Column(name = "EANcode", nullable = false, length = 13)
    private String eanCode;

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

    public static class GenerateEAN {

        private static final char[] DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

        public static String generate13DigitString() {
            Random random = new Random();
            StringBuilder builder = new StringBuilder();

            for (int i = 0; i < 13; i++) {
                builder.append(DIGITS[random.nextInt(DIGITS.length)]);
            }

            return builder.toString();
        }
    }
    public Product(String eanCode, String productName, String description, Maker maker, Category category, double sellPrice, Long quantity) {
        this.eanCode = eanCode;
        this.productName = productName;
        this.description = description;
        this.maker = maker;
        this.category = category;
        this.sellPrice = sellPrice;
        this.quantity = quantity;
    }

}
