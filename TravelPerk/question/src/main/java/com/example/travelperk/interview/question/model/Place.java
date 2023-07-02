package com.example.travelperk.interview.question.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Place {

    @JsonProperty("name")
    private String name;

    public Place(){}
    public Place(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
