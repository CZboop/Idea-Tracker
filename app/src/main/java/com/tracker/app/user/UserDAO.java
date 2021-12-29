package com.tracker.app.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UserDAO {

    Optional<User> findByEmail(String email);

    void signUp(User user);

    Optional<User> login(String email, String password);

    Optional<User> userExists(User user);

    Optional<User> userExistsById(int id);

    Optional<User> usernameExists(String username);
}
