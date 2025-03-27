package harjoitustyo.harjoitustyo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

import harjoitustyo.harjoitustyo.web.AppUserDetailServiceImpl;

@Configuration
@EnableMethodSecurity(securedEnabled = true)
public class WebSecurityConfig {
    @Autowired
    private AppUserDetailServiceImpl userDetailsService;

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {

        http
        .authorizeHttpRequests(authorize -> authorize
            .requestMatchers(antMatcher("/css/**")).permitAll()
            .requestMatchers(antMatcher("/signup")).permitAll()
            .requestMatchers(antMatcher("/saveuser")).permitAll()
            .requestMatchers(antMatcher("/addsubscription")).hasRole("ADMIN")
            .requestMatchers(antMatcher("/savesubscription")).hasRole("ADMIN")
            .requestMatchers(antMatcher("/editsubscription")).hasRole("ADMIN")
            .requestMatchers(antMatcher("/rest/subscriptions")).permitAll()
            .requestMatchers(antMatcher("/rest/subscriptions/**")).permitAll()
            .anyRequest().authenticated()
        )
        .csrf(csrf -> csrf
            .ignoringRequestMatchers(antMatcher("/rest/subscriptions/**"))
        )
        .headers(headers -> headers
            .frameOptions(frameoptions ->
            frameoptions.disable()
            )
        )
        .formLogin(formlogin -> formlogin
            .loginPage("/login")
            .defaultSuccessUrl("/subscriptions", true)
            .permitAll()
        )
        .logout(logout -> logout
            .permitAll()
        );

        return http.build();
    }

    @Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}
}
