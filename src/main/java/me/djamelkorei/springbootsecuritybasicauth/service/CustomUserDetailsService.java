package me.djamelkorei.springbootsecuritybasicauth.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import me.djamelkorei.springbootsecuritybasicauth.repository.UserRepository;

/**
 * Service for managing user authentication.
 *
 * @author Djamel Eddine Korei
 */
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findOneByUsername(username).orElseThrow(() -> {
            throw new UsernameNotFoundException(username);
        });
    }

}
