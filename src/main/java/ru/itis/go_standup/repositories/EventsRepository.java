package ru.itis.go_standup.repositories;

import ru.itis.go_standup.dto.EventDTO;
import ru.itis.go_standup.models.Event;
import ru.itis.go_standup.models.User;
import ru.itis.go_standup.repositories.generic.CrudRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface EventsRepository extends CrudRepository<Event, Integer> {
    List<EventDTO> getAllEventDTO();

}
