package com.tracker.app.user;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class User {

    private Long id;
    private String username;
    private String email;
    private String password;
    private Boolean activated;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }


}
