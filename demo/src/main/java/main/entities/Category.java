package main.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@SequenceGenerator(name = "categoryIdGenerator", sequenceName = "categoryIdGenerator", allocationSize = 1)
@Table(name="categories")
public class Category {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categoryIdGenerator")
    @Column(name = "id")
    private Integer id;

    //უფრო ადვილი სორტირებისთვის, შეიძლება არცაა საჭირო.
    @Column(name = "marker_id")
    private Integer markerID;

    @Column(name = "parent_id")
    private Integer parentID;

    @Column(name = "category_name")
    private String categoryName;

    public Category(Integer markerID, Integer parentID, String categoryName) {
        this.markerID = markerID;
        this.parentID = parentID;
        this.categoryName = categoryName;
    }
}
