package dto;

import entities.Category;
import entities.Maker;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductSearchParams {
    private Integer Id;
    private Maker maker;
    private Category category;
    private String ENAcode;

    public void setENACode(String s) {
    }
}
