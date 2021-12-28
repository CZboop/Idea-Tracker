package com.tracker.app.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public void signUp(@RequestBody User user){
        userService.signUp(user);
    }

//    TODO: change this to be user object
    @PostMapping("/login")
    public Optional<User> login(@RequestBody Map<String, String> info){
        return userService.login(info);
    }

    @GetMapping("exists")
    public boolean userExists(@RequestBody User user){
        return userService.userExists(user);
    }
}
