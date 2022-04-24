package com.skillbox.microservice.entity;

import lombok.Data;

@Data
public class MongoClient {
    private String firstName;
    private String lastName;
    private String email;

    @Override
    public String toString() {
        return firstName + " " + lastName + " " + email;
    }
}
