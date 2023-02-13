package main.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@SequenceGenerator(name = "makerIdGenerator", sequenceName = "makerIdGenerator", allocationSize = 1)
@Table(name="makers")
public class Maker {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "makerIdGenerator")
    @Column(name = "id")
    private Integer id;

    @Column(name = "maker_name", nullable = false)
    private String makerName;

}
