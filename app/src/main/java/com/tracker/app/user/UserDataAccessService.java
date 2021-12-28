package com.tracker.app.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserDataAccessService implements UserDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<User> findByEmail(String email){
        return null;
    }

    @Override
    public void signUp(User user){
        String sql = """
                INSERT INTO users (username, email, password) VALUES (?, ?, crypt(?, gen_salt('bf', 8)));
                """;
        jdbcTemplate.update(sql, user.getUsername(), user.getEmail(), user.getPassword());
    }
}
