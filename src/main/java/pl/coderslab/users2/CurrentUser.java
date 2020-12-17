package pl.coderslab.users2;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CurrentUser extends User {
    private final AppUser appUser;

    public CurrentUser(String nick, String password,
                       Collection<? extends GrantedAuthority> authorities,
                       AppUser appUser) {
        super(nick, password, authorities);
        this.appUser = appUser;
    }

    public AppUser getAppUser() {
        return appUser;
    }
}
