package finki.ukim.mk.mangashopbackend.services.impl;

import finki.ukim.mk.mangashopbackend.enumerators.Role;
import finki.ukim.mk.mangashopbackend.models.User;
import finki.ukim.mk.mangashopbackend.repository.UserRepository;
import finki.ukim.mk.mangashopbackend.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public User register(String username, String password, String repeatPassword, String name, String surname, Role role) {
        User user = new User(username,passwordEncoder.encode(password),name,surname,role);
        return userRepository.save(user);

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return (UserDetails) userRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException(username));
    }

}
