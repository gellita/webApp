package ru.itis.go_standup.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.UUID;
@Builder
@Data
public class EventDTO {
    private UUID id;
    private Date date;
    private String photo;
    private String name;
    private String link;
}

