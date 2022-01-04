package com.tracker.app.token;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TokenService {

    public Token createToken(Long user){
        return new Token(LocalDateTime.now(), user);
    }
}
