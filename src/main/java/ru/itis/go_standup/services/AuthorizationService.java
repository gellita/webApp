package ru.itis.go_standup.services;
import ru.itis.go_standup.dto.SignInDTO;
import ru.itis.go_standup.dto.SignUpDTO;
import ru.itis.go_standup.dto.UserDTO;
import ru.itis.go_standup.exceptions.StandupException;

public interface AuthorizationService {
    UserDTO signUp(SignUpDTO form) throws StandupException;
    UserDTO signIn(SignInDTO form) throws StandupException;
}
