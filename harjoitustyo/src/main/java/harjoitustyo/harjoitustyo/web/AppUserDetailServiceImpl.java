package harjoitustyo.harjoitustyo.web;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import harjoitustyo.harjoitustyo.domain.AppUsers;
import harjoitustyo.harjoitustyo.domain.AppUsersRepository;
import harjoitustyo.harjoitustyo.domain.Roles;
import harjoitustyo.harjoitustyo.domain.RolesRepository;

@Service
public class AppUserDetailServiceImpl implements UserDetailsService {

    @Autowired
    AppUsersRepository appUsersRepository;

    @Autowired
    RolesRepository rolesRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUsers currentUser = null;
        try {
            currentUser = appUsersRepository.findByUsername(username);
            if (currentUser == null) {
                throw new UsernameNotFoundException("User not found: " + username);
            }
        } catch (Exception e) {
            throw new UsernameNotFoundException("Error loading user by username: " + username, e);
        }

        Roles role = currentUser.getRole();
        String roleName = "ROLE_" + role.getRoleName();

        UserDetails user = new org.springframework.security.core.userdetails.User(
            currentUser.getUsername(),
            currentUser.getPasswordhash(),
            Collections.singletonList(new SimpleGrantedAuthority(roleName))
        );
        return user;
    }
}
