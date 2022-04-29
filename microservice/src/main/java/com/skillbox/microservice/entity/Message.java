package com.skillbox.microservice.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "message")
public class Message {
    @Id
    private String id;
    private LocalDateTime dateOfApplication;
    private Client client;
    private String message;

    @Override
    public String toString() {
        return id + " " + dateOfApplication + " " + client + " " + message;
    }
}
