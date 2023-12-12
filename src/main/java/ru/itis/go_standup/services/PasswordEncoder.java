package ru.itis.go_standup.services;

public interface PasswordEncoder {
    boolean matches(String password, String hashPassword);
    String encode(String password);
}
