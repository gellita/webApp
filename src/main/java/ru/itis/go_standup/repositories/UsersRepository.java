package ru.itis.go_standup.repositories;

import ru.itis.go_standup.models.User;
import ru.itis.go_standup.repositories.generic.CrudRepository;

import java.util.Optional;

public interface UsersRepository extends CrudRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
