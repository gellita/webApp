package ru.itis.go_standup.services;

import ru.itis.go_standup.dto.EventDTO;

import java.util.List;


public interface EventService {
    List<EventDTO> getEventDTO();

}
