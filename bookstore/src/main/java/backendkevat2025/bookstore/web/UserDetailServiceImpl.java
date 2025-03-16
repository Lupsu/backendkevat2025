package backendkevat2025.bookstore.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import backendkevat2025.bookstore.domain.AppUser;
import backendkevat2025.bookstore.domain.AppUserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    private static final Logger logger = LoggerFactory.getLogger(UserDetailServiceImpl.class);

    @Autowired
    AppUserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("Loading user by username: {}", username);
        AppUser currentUser = null;
        try {
            currentUser = repository.findByUsername(username);
            if (currentUser == null) {
                logger.error("User not found: {}", username);
                throw new UsernameNotFoundException("User not found: " + username);
            }
        } catch (Exception e) {
            logger.error("Error loading user by username: {}", username, e);
            throw new UsernameNotFoundException("Error loading user by username: " + username, e);
        }

        UserDetails user = new org.springframework.security.core.userdetails.User(
            username, 
            currentUser.getPasswordHash(), 
            AuthorityUtils.createAuthorityList(currentUser.getRole())
        );
        return user;
    }
}