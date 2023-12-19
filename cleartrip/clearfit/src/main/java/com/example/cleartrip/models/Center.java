package com.example.cleartrip.models;

import java.util.ArrayList;
import java.util.List;

public class Center {

    String name;
    List<Timing> timings;
    List<String> activities;

    public Center(String name) {
        this.name = name;
        this.timings = new ArrayList<>();
        this.activities = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Timing> getTimings() {
        return timings;
    }

    public List<String> getActivities() {
        return activities;
    }

    public void addTimings(Timing timing) {
        this.timings.add(timing);
    }

    public void addActivity(String activity) {
        this.activities.add(activity);
    }
}
