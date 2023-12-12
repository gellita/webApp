package ru.itis.go_standup.services;

import ru.itis.go_standup.dto.SignUpDTO;
import ru.itis.go_standup.dto.UserDTO;
import ru.itis.go_standup.models.User;

public interface UserMapper {
    UserDTO toDTO(User user);
    User toUser(UserDTO dto);
    User toUser(SignUpDTO dto);
}
