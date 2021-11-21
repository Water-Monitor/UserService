package watermonitor.userservice.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Collections;
import lombok.RequiredArgsConstructor;
import watermonitor.userservice.models.dao.UserDao;

@Service
@RequiredArgsConstructor
public class AuthenticationUserDetailService implements UserDetailsService {
    private final UserService userService;
    @Override public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDao apiUser = userService.readUserByUsername(username);
        if (apiUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return new org.springframework.security.core.userdetails.User(apiUser.getUsername(), apiUser.getPassword(), Collections.emptyList());
    }
}