package harjoitustyo.harjoitustyo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import harjoitustyo.harjoitustyo.domain.AppUsers;
import harjoitustyo.harjoitustyo.domain.AppUsersRepository;

@Service
public class AppUserDetailServiceImpl implements UserDetailsService {
    @Autowired
    AppUsersRepository appUsersRepository;

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

        UserDetails user = new org.springframework.security.core.userdetails.User(
            username, 
            currentUser.getPasswordhash(),
            AuthorityUtils.createAuthorityList(currentUser.getRole().toString())
        );
        return user;
    }
}
