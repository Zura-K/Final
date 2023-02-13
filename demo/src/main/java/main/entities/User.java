package main.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import main.interfaces.UserInterface;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@SequenceGenerator(name = "userIdGenerator", sequenceName = "userIdGenerator", allocationSize = 1)
@Table(name="users")
public class User implements UserInterface {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userIdGenerator")
    @Id
    @Column(name = "id")
    private Integer id;

    public User(Boolean role, String name, String password, Boolean active) {
        this.role = role;
        this.username = name;
        this.password = password;
        this.active = active;
    }

    @Column(name = "role", nullable = false)
    private Boolean role; //isSalesman==false, isManager==true

    @Column(name = "name", unique = true, nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "activity", nullable = false)
    private Boolean active;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        if (role.equals(true)) {
            authorities.add(new SimpleGrantedAuthority("ROLE_Manager"));
        } else if (role.equals(false)) {
            authorities.add(new SimpleGrantedAuthority("ROLE_Salesman"));
        }
        return authorities;
    }
}
