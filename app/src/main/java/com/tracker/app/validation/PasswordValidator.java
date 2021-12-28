package com.tracker.app.validation;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class PasswordValidator implements Predicate<String> {

    public boolean test(String password){
        Pattern VALID_EMAIL_ADDRESS_REGEX =
                Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(password);
        return matcher.find();
    }
}
