package com.example.myapplication.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.UUID;

public class Actor {
    private UUID id;
    private String name;
    private Boolean gender;//true = female; false = male

    public Actor() {

    }

    public Actor(String name, Boolean gender) {
        this.name = name;
        this.gender = gender;
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public Boolean getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "Error while converting to String";
        }
    }
}
