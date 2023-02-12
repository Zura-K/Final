package entities;

import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@SequenceGenerator(name = "makerIdGenerator", sequenceName = "makerIdGenerator", allocationSize = 1)
@Table(name="makers")
public class Maker {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "makerIdGenerator")
    private Integer id;

    @Column(name = "maker_name", nullable = false)
    private String makerName;

}
