package com.tracker.app.user;

import lombok.*;

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

    public User(Long id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }


}
