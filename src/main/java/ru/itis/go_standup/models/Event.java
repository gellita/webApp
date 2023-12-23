package ru.itis.go_standup.models;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.UUID;
@Data
@Builder
public class Event {
    private UUID id;
    private Date date;
    private String photo;
    private String name;
    private String link;

}
