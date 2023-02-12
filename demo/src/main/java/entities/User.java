package entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Setter
@Getter
@NoArgsConstructor
@SequenceGenerator(name = "userIdGenerator", sequenceName = "userIdGenerator", allocationSize = 1)
@Table(name="users")
public class User implements interfaces.UserInterface {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userIdGenerator")
    @Id
    private Integer id;

    public enum Role {
        RoleCashier,
        RoleSalesman
    }

    @Column(name = "role", nullable = false)
    private Role role;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "activity", nullable = false)
    private Boolean active;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        if (role.equals("RoleManager")) {
            authorities.add(new SimpleGrantedAuthority("ROLE_Manager"));
        } else if (role.equals("RoleSalesman")) {
            authorities.add(new SimpleGrantedAuthority("ROLE_Salesman"));
        }
        return authorities;
    }
}
