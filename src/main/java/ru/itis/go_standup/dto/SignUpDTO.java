package ru.itis.go_standup.dto;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;
@Data
@Builder
public class SignUpDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Instant birthdate;
}
