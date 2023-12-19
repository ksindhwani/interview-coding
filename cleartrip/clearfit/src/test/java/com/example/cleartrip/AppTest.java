package com.example.cleartrip;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.example.cleartrip.models.Admin;
import com.example.cleartrip.models.CenterManager;
import com.example.cleartrip.models.SessionManager;
import com.example.cleartrip.models.Timing;
import com.example.cleartrip.models.Workout;
import com.example.cleartrip.models.WorkoutManager;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    CenterManager centerManager; 
    WorkoutManager workoutManager; 
    SessionManager sessionManager;
    Admin admin;

    @Before
    public void setup() throws Exception {
        centerManager = new CenterManager();
        workoutManager = new WorkoutManager();

        centerManager.AddCentre("Koramangala");
        centerManager.AddCentre("Bellandur");

        centerManager.AddCentreTimings("Koramangala", new Timing(6, 9));
        centerManager.AddCentreTimings("Koramangala",new Timing(18, 21));

        centerManager.AddCentreActivities("Koramangala", "Weights");
        centerManager.AddCentreActivities("Koramangala", "Cardio");
        centerManager.AddCentreActivities("Koramangala", "Yoga");
        centerManager.AddCentreActivities("Koramangala", "Swimming");


        centerManager.AddCentreTimings("Bellandur", new Timing(7, 10));
        centerManager.AddCentreTimings("Koramangala",new Timing(19, 22));

        centerManager.AddCentreActivities("Bellandur", "Weights");
        centerManager.AddCentreActivities("Bellandur", "Cardio");
        centerManager.AddCentreActivities("Bellandur", "Yoga");

    }

    @Test
    public void allValidShouldPass() throws Exception
    {
        // add workouts 
        Admin admin = new Admin(workoutManager, centerManager);

        admin.AddWorkout("Koramangala", "Weights", 6, 7, 100); 
        admin.AddWorkout("Koramangala", "Cardio", 7, 8, 150); 
        admin.AddWorkout("Koramangala", "Yoga", 8, 9, 200); 


        admin.AddWorkout("Bellandur", "Cardio", 19, 20, 20); 
        admin.AddWorkout("Bellandur", "Weights", 20, 21, 100); 
        admin.AddWorkout("Bellandur", "Weights", 21, 22, 100); 

        // User Operations

        sessionManager = new SessionManager(workoutManager);
        sessionManager.registerUser("Vaibhav");

        List<Workout> workouts = sessionManager.viewWorkoutAvailability("Weights");

        assertEquals(workouts.size(), 3);
        assertEquals(workouts.get(0).toString(), "Workout - Koramangala,Weights,6,7,100");
    }
}
