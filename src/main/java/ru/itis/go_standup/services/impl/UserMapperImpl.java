package ru.itis.go_standup.services.impl;


import ru.itis.go_standup.dto.SignUpDTO;
import ru.itis.go_standup.dto.UserDTO;
import ru.itis.go_standup.models.User;
import ru.itis.go_standup.services.UserMapper;

public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO toDTO(User user) {
        return UserDTO.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
//                .birthdate(user.getBirthdate())
                .build();
    }

    @Override
    public User toUser(UserDTO dto) {
        return User.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
//                .birthdate(dto.getBirthdate())
                .build();
    }

    @Override
    public User toUser(SignUpDTO dto) {
        return User.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
//                .birthdate(dto.getBirthdate())
                .passwordHash(dto.getPassword())
                .build();
    }
}
