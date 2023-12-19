package com.example.cleartrip.models;

import java.util.HashMap;
import java.util.Map;

public class CenterManager {

   Map<String, Center> centres;

    public CenterManager() {
        centres = new HashMap<>();
    }
    
    public Map<String, Center> getCentres() {
        return centres;
    }
    
    public Center getCenter(String centerName) throws Exception {
        if(centres.containsKey(centerName)) {
            return centres.get(centerName);
        } 
        throw new Exception("invalid centre name");
    }


    public void AddCentre(String centerName) {
        centres.put(centerName, new Center(centerName));
    }

    public void AddCentreTimings(String centerName, Timing timing) throws Exception {
        if(!centres.containsKey(centerName)) {
            throw new Exception("Centre is not registered yet");
        }   

        Center center = centres.get(centerName);
        center.addTimings(timing);
    }

    public void AddCentreActivities(String centerName, String activity) throws Exception {
        if(!centres.containsKey(centerName)) {
            throw new Exception("Centre is not registered yet");
        }   

        Center center = centres.get(centerName);
        center.addActivity(activity);
    }


}
