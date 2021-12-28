package com.tracker.app.user;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class UserService {

    private final UserDAO userDAO;
    private final static String UserNotFoundMessage = "User with email %s not found";

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    public void signUp(User user) {
//        TODO: validation before adding
        userDAO.signUp(user);
    }

    public Optional<User> login(Map<String, String> info) {
        return userDAO.login(info.get("email"), info.get("password"));
    }
}
