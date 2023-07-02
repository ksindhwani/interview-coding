package com.example.travelperk.interview.question.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Time {

    @JsonProperty("updated")
    private String updated;

    @JsonProperty("updatedISO")
    private String updatedISO;

    @JsonProperty("updateduk")
    private String updatedDuk;

    public Time(String updated, String updatedISO, String updatedDuk) {
        this.updated = updated;
        this.updatedISO = updatedISO;
        this.updatedDuk = updatedDuk;
    }

    public String getUpdated() {
        return updated;
    }

    public String getUpdatedISO() {
        return updatedISO;
    }

    public String getUpdatedDuk() {
        return updatedDuk;
    }
}
