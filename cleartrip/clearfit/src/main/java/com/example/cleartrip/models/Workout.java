package com.example.cleartrip.models;

public class Workout {
    String centreName;
    String type;
    int StartTime;
    int EndTime;
    int availableSlots;
    
    public Workout(String centreName, String type, int startTime, int endTime, int availableSlots) {
        this.centreName = centreName;
        this.type = type;
        StartTime = startTime;
        EndTime = endTime;
        this.availableSlots = availableSlots;
    }

    

    @Override
    public String toString() {
        return "Workout - " + centreName + "," + type + "," + StartTime + "," + EndTime + "," + availableSlots;
    }



    public String getCentreName() {
        return centreName;
    }

    public String getType() {
        return type;
    }

    public int getStartTime() {
        return StartTime;
    }

    public int getEndTime() {
        return EndTime;
    }

    public int getAvailableSlots() {
        return availableSlots;
    }

    public void updateSlots() {
        availableSlots--;
    }
}
