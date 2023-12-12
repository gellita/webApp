package ru.itis.go_standup.services.impl;


import ru.itis.go_standup.services.PasswordEncoder;

public class PasswordEncoderImpl implements PasswordEncoder {
    @Override
    public boolean matches(String password, String hashPassword) {
        return encode(password).equals(hashPassword);
    }

    @Override
    public String encode(String password) {
        StringBuilder hash = new StringBuilder();
        for(int i = 0; i < password.length(); i++) {
            hash.append(password.charAt(i) * i);
        }
        return hash.toString();
    }
}
