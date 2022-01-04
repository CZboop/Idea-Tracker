package com.tracker.app.token;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Token {
    private LocalDateTime issuedAt;
    private Long userId;

    public Token(LocalDateTime issuedAt, Long userId) {
        this.issuedAt = issuedAt;
        this.userId = userId;
    }
}
