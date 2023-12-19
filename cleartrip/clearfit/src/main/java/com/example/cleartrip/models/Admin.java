package com.example.cleartrip.models;

public class Admin {

    WorkoutManager workoutManager;
    CenterManager centerManager;

    public Admin(WorkoutManager workoutManager, CenterManager centerManager) {
        this.workoutManager = workoutManager;
        this.centerManager = centerManager;
    }

    public void AddWorkout(String centerName, String workoutType, int startTime, int endTime, int availableSlots) {
        try {
            Center center = centerManager.getCenter(centerName);
            if(workoutIsPresentInCentre(center,workoutType)) {
                workoutManager.AddWorkout(centerName, workoutType, startTime, endTime, availableSlots);
            }

        } catch (Exception e) {
            System.out.println("Cannot add workout " + e.getMessage());
        }
    }

    private boolean workoutIsPresentInCentre(Center center, String workoutType) {
        return center.getActivities().contains(workoutType);
    }
}
