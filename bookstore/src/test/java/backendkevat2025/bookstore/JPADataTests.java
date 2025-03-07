package backendkevat2025.bookstore;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import backendkevat2025.bookstore.domain.AppUser;
import backendkevat2025.bookstore.domain.AppUserRepository;

@DataJpaTest
public class JPADataTests {
    @Autowired
    private AppUserRepository appUserRepository;

    @Test
    public void findByUsernameShouldReturnUsername() {
        AppUser appuser = appUserRepository.findByUsername("user");
        assertThat(appuser).isNotNull();
        
    }

    @Test
    public void createUserShouldSaveUser() {
        AppUser newUser = new AppUser("newuser", "password", "email", "USER");
        appUserRepository.save(newUser);

        AppUser foundUser = appUserRepository.findByUsername("newuser");
        assertThat(foundUser).isNotNull();
        assertThat(foundUser.getUsername()).isEqualTo("newuser");
    }

    @Test
    public void deleteUserShouldDeleteUser() {
        AppUser newUser = new AppUser("newuser", "password", "email", "USER");
        appUserRepository.save(newUser);
        appUserRepository.delete(newUser);

        AppUser foundUser = appUserRepository.findByUsername("newuser");
        assertThat(foundUser).isNull();
    }
    
}
