package ru.itis.go_standup.services.impl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ru.itis.go_standup.dto.EventDTO;
import ru.itis.go_standup.models.Event;
import ru.itis.go_standup.repositories.EventsRepository;
import ru.itis.go_standup.repositories.impl.EventsRepositoryImpl;
import ru.itis.go_standup.services.EventService;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
public class EventServiceImpl implements EventService {
    private EventsRepository eventsRepository;

    @Override
    public List<EventDTO> getEventDTO() {
        return eventsRepository.getAllEventDTO();
    }
}


