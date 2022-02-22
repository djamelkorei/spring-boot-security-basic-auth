package me.djamelkorei.springbootsecuritybasicauth.web;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import me.djamelkorei.springbootsecuritybasicauth.domain.User;

/**
 * Rest controller
 * 
 * @author Djamel Eddine Korei
 */
@RestController
public class AppResource {

    @GetMapping("/**")
    public String guest() {
        return "Hello World";
    }

    @GetMapping("/secured")
    public String secured(Authentication auth) {
        User user = ((User) auth.getPrincipal());
        return "Hello " + user.getFirstName() + " " + user.getLastName();
    }

}