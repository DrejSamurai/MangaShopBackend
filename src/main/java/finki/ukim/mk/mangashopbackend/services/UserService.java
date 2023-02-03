package finki.ukim.mk.mangashopbackend.services;

import finki.ukim.mk.mangashopbackend.enumerators.Role;
import finki.ukim.mk.mangashopbackend.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User register(String username, String password, String repeatPassword, String name, String surname, Role role);
}

