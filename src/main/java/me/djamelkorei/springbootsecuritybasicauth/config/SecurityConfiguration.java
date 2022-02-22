package me.djamelkorei.springbootsecuritybasicauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import me.djamelkorei.springbootsecuritybasicauth.repository.UserRepository;
import me.djamelkorei.springbootsecuritybasicauth.service.CustomUserDetailsService;

/**
 * Web security configuration.
 *
 * @author Djamel Eddine Korei
 */
@Configuration
public class SecurityConfiguration {

    /**
     * Define the password encoder.
     * 
     * @return {@link BCryptPasswordEncoder}
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Define the user service to retrieve and authenticate the user.
     * 
     * @param userRepository
     * @return {@link UserDetails}
     */
    @Bean
    CustomUserDetailsService customUserDetailsService(UserRepository userRepository) {
        return new CustomUserDetailsService(userRepository);
    }

    /**
     * Define the filer chain.
     * 
     * @param http
     * @return {@link SecurityFilterChain}
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                (authz) -> authz.antMatchers("/secured").authenticated().anyRequest().permitAll())
                .httpBasic();
        return http.build();
    }

}
