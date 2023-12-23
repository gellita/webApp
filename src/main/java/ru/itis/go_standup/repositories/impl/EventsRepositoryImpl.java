package ru.itis.go_standup.repositories.impl;
import lombok.AllArgsConstructor;
import ru.itis.go_standup.dto.EventDTO;
import ru.itis.go_standup.models.Event;
import ru.itis.go_standup.repositories.EventsRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
public class EventsRepositoryImpl implements EventsRepository {
    private final Connection connection;
    private static final String SQL_GET_EVENT_DTO = "select * from events";

    @Override
    public List<EventDTO> getAllEventDTO() {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_EVENT_DTO);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<EventDTO> result = new ArrayList<>();
            while (resultSet.next()) {
                EventDTO eventDto = EventDTO.builder()
                        .id((UUID) resultSet.getObject("id"))
                        .date(resultSet.getDate("date"))
                        .photo(resultSet.getString("photo"))
                        .name(resultSet.getString("name"))
                        .link(resultSet.getString("link"))
                        .build();
                result.add(eventDto);
            }
            return result;

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public EventsRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Optional<Event> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Event> findAll() {
        return null;
    }

    @Override
    public Event save(Event item) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}


