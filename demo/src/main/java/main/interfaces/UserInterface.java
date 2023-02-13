package main.interfaces;

import main.entities.User;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

public interface UserInterface {
    Collection<? extends GrantedAuthority> getAuthorities();
}
