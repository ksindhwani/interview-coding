package com.example.cleartrip.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorkoutManager {

    Map<String, List<Workout>> workouts;
    public WorkoutManager() {
        this.workouts = new HashMap<>();
    }


    public void AddWorkout(String centerName, String workoutType, int startTime, int endTime, int availableSlots) {
        Workout workout = new Workout(centerName, workoutType, startTime, endTime, availableSlots);
        List<Workout> centreWorkouts = new ArrayList<>();
        centreWorkouts = workouts.getOrDefault(workoutType, centreWorkouts);
        centreWorkouts.add(workout);
        workouts.put(workoutType, centreWorkouts);
    }

    public List<Workout> viewWorkoutAvailability(String workoutType) {
        return workouts.getOrDefault(workoutType, null);
    }


    public void updateWorkoutSlots(String workoutType, String centreName, int startTime, int endTime) {
        List<Workout> workouts = findWorkoutListByType(workoutType);
        for(Workout workout : workouts) {
            if(workout.getCentreName().equalsIgnoreCase(centreName)
            && workout.getStartTime() == startTime
            && workout.getEndTime() == endTime) {
                workout.updateSlots();
            }
        }
    }


    private List<Workout> findWorkoutListByType(String workoutType) {
        return workouts.get(workoutType);
    }
}
