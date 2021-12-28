package com.tracker.app.user;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserDataAccessService implements UserDAO {

    @Override
    public Optional<User> findByEmail(String email){
        return null;
    }

    @Override
    public void signUp(User user){
        
    }
}
