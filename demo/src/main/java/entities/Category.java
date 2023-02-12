package entities;

import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@SequenceGenerator(name = "categoryIdGenerator", sequenceName = "categoryIdGenerator", allocationSize = 1)
@Table(name="categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categoryIdGenerator")
    private Integer id;

    @Column(name = "parent_id")
    private Integer parentID;

    @Column(name = "category_name")
    private String categoryName;

}
