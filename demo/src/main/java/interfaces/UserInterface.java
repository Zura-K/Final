package interfaces;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public interface UserInterface {
    Collection<? extends GrantedAuthority> getAuthorities();
}
