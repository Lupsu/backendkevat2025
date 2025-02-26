package backendkevat2025.bookstore.web;
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
    @Autowired
    AppUserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser currentUser = repository.findByUsername(username);
        UserDetails user = new org.springframework.security.core.userdetails.User(username, currentUser.getPasswordHash(), 
            AuthorityUtils.createAuthorityList(currentUser.getRole()));
        return user;
    }
}
