package com.tracker.app.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserDataAccessService implements UserDAO {

    private JdbcTemplate jdbcTemplate;
    private UserRowMapper userRowMapper;

    @Autowired
    public UserDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.userRowMapper = new UserRowMapper();
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

    @Override
    public Optional<User> login(String email, String password){
        String sql = """
                SELECT * FROM users WHERE email = ? AND password = crypt(?, password);
                """;
        return jdbcTemplate.query(sql, userRowMapper, email, password).stream().findFirst();
    }

    @Override
    public Optional<User> userExists(User user){
        String sql = """
                SELECT * FROM users WHERE email = ?;
                """;
        return jdbcTemplate.query(sql, userRowMapper, user.getEmail()).stream().findFirst();
    }

    @Override
    public Optional<User> userExistsById(int id){
        String sql = """
                SELECT * FROM users WHERE id = ?;
                """;
        return jdbcTemplate.query(sql, userRowMapper, id).stream().findFirst();
    }

    @Override
    public Optional<User> usernameExists(String username){
        String sql = """
                SELECT * FROM users WHERE username = ?;
                """;
        return jdbcTemplate.query(sql, userRowMapper, username).stream().findFirst();
    }
}
