package com.tracker.app.user;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserDAO userDAO;
    private final static String UserNotFoundMessage = "User with email %s not found";

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void signUpUser(User user){
        boolean userExists = userDAO.findByEmail(user.getEmail()).isPresent();
        if (userExists){
            throw new IllegalStateException("Email already in use");
        }

    }

    public void signUp(User user) {
        userDAO.signUp(user);
    }
}
