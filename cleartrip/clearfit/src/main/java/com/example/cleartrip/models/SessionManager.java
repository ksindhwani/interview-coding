package com.example.cleartrip.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SessionManager {

    Set<String> users;
    WorkoutManager workoutManager;
    Map<String, List<Session>> userSessionsMap;

    public SessionManager(WorkoutManager workoutManager) {
        this.users = new HashSet<>();
        this.workoutManager = workoutManager;
        userSessionsMap = new HashMap<>();
    }

    public void registerUser(String name) {
        users.add(name);
    }

    public List<Workout> viewWorkoutAvailability(String workoutType) throws Exception {
        List<Workout> workouts = workoutManager.viewWorkoutAvailability(workoutType);
        if(workouts == null ){
            throw new Exception("Invalid Workout type");
        }
        return workouts;
    }
    
    public void bookSession(String userName, String centreName, String workoutType, int startTime, int endTime) throws Exception {
        if(!userIsRegisteredWithUs(userName)) {
            throw new Exception("User is not registered");
        }

        Session Session = new Session(userName, centreName, workoutType, startTime, endTime);
        List<Session> userSessions = new ArrayList<>();
        userSessions = userSessionsMap.getOrDefault(userName, userSessions);
        userSessions.add(Session);
        userSessionsMap.put(workoutType, userSessions);


        workoutManager.updateWorkoutSlots(workoutType, centreName, startTime, endTime);

    }

    private boolean userIsRegisteredWithUs(String userName) {
        return userSessionsMap.containsKey(userName);
    } 

    public void CancelSession(String userName, String centreName, String workoutType, int startTime, int endTime) throws Exception {
        List<Session> userSessions = userSessionsMap.get(userName);
        Session session = findSession(userSessions, centreName,workoutType, startTime, endTime);
        if(session == null) {
            throw new Exception("No valid session found");
        }
        session.cancelSession();
        
    }

    private Session findSession(List<Session> userSessions, String centreName, String workoutType, int startTime,
            int endTime) {
        for(Session session : userSessions) {
            if(session.getCentreName().equalsIgnoreCase(centreName)
            && session.getWorkoutType().equalsIgnoreCase(workoutType)
            && session.getStartTime() == startTime
            && session.getEndTime() == endTime) {
                return session;
            }
             
        }
        return null;
    }

}
