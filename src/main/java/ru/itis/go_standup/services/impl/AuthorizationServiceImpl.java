package ru.itis.go_standup.services.impl;

import lombok.AllArgsConstructor;
import ru.itis.go_standup.dto.SignInDTO;
import ru.itis.go_standup.dto.SignUpDTO;
import ru.itis.go_standup.dto.UserDTO;
import ru.itis.go_standup.exceptions.StandupException;
import ru.itis.go_standup.models.User;
import ru.itis.go_standup.repositories.UsersRepository;
import ru.itis.go_standup.services.AuthorizationService;
import ru.itis.go_standup.services.PasswordEncoder;
import ru.itis.go_standup.services.UserMapper;

import java.util.Optional;

@AllArgsConstructor
public class AuthorizationServiceImpl implements AuthorizationService {
    private UsersRepository usersRepository;
    private UserMapper userMapper;
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDTO signUp(SignUpDTO form) throws StandupException {
        if (form.getEmail() == null) {
            throw new StandupException("Email cannot be null");
        }
        Optional<User> optionalUser = usersRepository.findByEmail(form.getEmail());
        if (optionalUser.isPresent()) {
            throw new StandupException("User with email " + form.getEmail() + " already exist");
        }
        form.setPassword(passwordEncoder.encode(form.getPassword()));
        User user = userMapper.toUser(form);
        User savedUser = usersRepository.save(user);
        return userMapper.toDTO(savedUser);
    }

    @Override
    public UserDTO signIn(SignInDTO form) throws StandupException {
        if(form.getEmail() == null) {
            throw new StandupException("Email cannot be null");
        }
        Optional<User> optionalUser = usersRepository.findByEmail(form.getEmail());
        if(optionalUser.isEmpty()) {
            throw new StandupException("User with email " + form.getEmail() + " not found.");
        }
        User user = optionalUser.get();
        if(!passwordEncoder.matches(form.getPassword(), user.getPasswordHash())) {
            throw new StandupException("Wrong password");
        }
        return userMapper.toDTO(user);
    }
}
