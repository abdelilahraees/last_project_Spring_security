package app.Security;

import java.util.Arrays;
import java.util.Collection;

import app.Security.Repository.UserRepository;
import app.model.Role;
import app.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        User user = userRepository.findByUsernameOrEmail(username, username);
        if (user == null) {
            throw new UsernameNotFoundException("Email or Password not found");
        }
        System.out.println(user.getRoles().isEmpty());
        return new CustomUserDetails(user.getUsername(), user.getEmail(), user.getPassword(), getAuthorities(user), user.getFullname());

    }

    private static Collection<? extends GrantedAuthority> getAuthorities(User user) {
        String[] userRoles = user.getRoles().stream().map(Role::getRole).toArray(String[]::new);
        return AuthorityUtils.createAuthorityList(userRoles);
    }


}