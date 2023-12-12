package ru.itis.go_standup.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class SignInDTO {
    private String email;
    private String password;
}
