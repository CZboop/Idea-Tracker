package com.tracker.app.user;

import com.tracker.app.validation.EmailValidator;
import com.tracker.app.validation.PasswordValidator;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class UserService {

    private final UserDAO userDAO;
    private final static String UserNotFoundMessage = "User with email %s not found";
    private final EmailValidator emailValidator;
    private final PasswordValidator passwordValidator;

    public UserService(UserDAO userDAO, EmailValidator emailValidator, PasswordValidator passwordValidator) {
        this.userDAO = userDAO;
        this.emailValidator = emailValidator;
        this.passwordValidator = passwordValidator;
    }

    public void signUp(User user) {
//        TODO: validation before adding
        boolean isValidEmail = emailValidator.
                test(user.getEmail());
        if (!isValidEmail){
            throw new IllegalStateException(String.format("%s is not a valid email", user.getEmail()));
        }
        if (userExists(user)){
            throw new IllegalStateException("This email is already in use");
        }
        boolean isStrongPassword = passwordValidator
                .test(user.getPassword());
        if (!isStrongPassword){
            throw new IllegalStateException("""
        Password isn't strong enough. 
        Please enter a password with at least eight characters, including at least one uppercase letter, 
        one lowercase letter, one number and one special character
        """);
        }
        userDAO.signUp(user);
    }

    public Optional<User> login(Map<String, String> info) {
        return userDAO.login(info.get("email"), info.get("password"));
    }

    public boolean userExists(User user){
        return userDAO.userExists(user).isPresent();
    }
}
