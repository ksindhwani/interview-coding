package com.example.cleartrip.models;

public class Session {
    String userName;
    String centreName;
    String workoutType;
    int startTime;
    int endTime;
    boolean status;

    public Session(String userName, String centreName, String workoutType, int startTime, int endTime) {
        this.userName = userName;
        this.centreName = centreName;
        this.workoutType = workoutType;
        this.startTime = startTime;
        this.endTime = endTime;
        status = true;
    }
    
    public void cancelSession() {
        status = false;
    }

    public String getUserName() {
        return userName;
    }

    public String getCentreName() {
        return centreName;
    }

    public String getWorkoutType() {
        return workoutType;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public boolean isStatus() {
        return status;
    }

    
}
