package com.example.travelperk.interview.question.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FourSquare {

    @JsonProperty("results")
    private Place[] results;

    public FourSquare(){};
    public FourSquare(Place[] results) {
        this.results = results;
    }

    public Place[] getResults() {
        return results;
    }
}
