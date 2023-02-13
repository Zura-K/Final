package main.dto;

import main.entities.Category;
import main.entities.Maker;
import main.entities.Product;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductSearchParams {
    private Integer Id;
    private Maker maker;
    private Category category;
    private Product eanCode;

}
