package com.tracker.app.user;

import org.springframework.stereotype.Service;

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
}
