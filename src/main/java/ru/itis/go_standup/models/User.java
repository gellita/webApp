package ru.itis.go_standup.models;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Data
@Builder
public class User {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String passwordHash;
    private Instant birthdate;
}
