package me.djamelkorei.springbootsecuritybasicauth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.djamelkorei.springbootsecuritybasicauth.domain.User;

/**
 * Spring Data JPA Repository for the {@link User} entity.
 * 
 * @author Djamel Eddine Korei
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findOneByUsername(String username);
}
