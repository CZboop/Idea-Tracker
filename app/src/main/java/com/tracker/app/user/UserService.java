package com.tracker.app.user;

import com.tracker.app.validation.EmailValidator;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class UserService {

    private final UserDAO userDAO;
    private final static String UserNotFoundMessage = "User with email %s not found";
    private final EmailValidator emailValidator;

    public UserService(UserDAO userDAO, EmailValidator emailValidator) {
        this.userDAO = userDAO;
        this.emailValidator = emailValidator;
    }


    public void signUp(User user) {
//        TODO: validation before adding
        boolean isValidEmail = emailValidator.
                test(user.getEmail());
        if (!isValidEmail){
            throw new IllegalStateException(String.format("%s is not a valid email", user.getEmail()));
        }
        userDAO.signUp(user);
    }

    public Optional<User> login(Map<String, String> info) {
        return userDAO.login(info.get("email"), info.get("password"));
    }
}
