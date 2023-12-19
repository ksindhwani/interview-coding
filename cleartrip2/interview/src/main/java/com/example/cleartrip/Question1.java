package com.example.cleartrip;

import java.util.Arrays;

class Patient implements Comparable<Patient> {
    int startDate;
    int EndDate;
    
    public Patient(int startDate, int endDate) {
        this.startDate = startDate;
        EndDate = endDate;
    }
    public int getStartDate() {
        return startDate;
    }
    public int getEndDate() {
        return EndDate;
    }

    @Override
    public int compareTo(Patient p) {
        return this.EndDate - p.EndDate;
    }
}

public class Question1 {

    int rr = 0, nap = 0;
    int overalappingIntervalStart = Integer.MAX_VALUE;
    int overalappingIntervalEnd = Integer.MIN_VALUE;

    public void nRoomRequired(Patient[] patients, int n, int m) {
        if(n == 0) {
            rr = 0;
            nap = m;
            return;
        }
        Arrays.sort(patients);
        rr +=1;
        updateOverlappingInterval(patients[0].getStartDate(), patients[0].getEndDate());
        
        for(int i = 1;i<m;i++) {
            if(intervalOverlapping(patients[i].getStartDate(),patients[i].getEndDate())) {
                if(rr < n) {
                    rr++;
                    updateOverlappingInterval(patients[0].getStartDate(), patients[0].getEndDate());
                } else {
                    nap++;
                }
            }
        }
    }

    private boolean intervalOverlapping(int startDate, int endDate) {
        return !(endDate < overalappingIntervalStart || startDate > overalappingIntervalEnd);
    }

    private void updateOverlappingInterval(int startDate, int endDate) {
        if(startDate < overalappingIntervalStart) {
            overalappingIntervalStart = startDate;
        }
        
        if(endDate > overalappingIntervalEnd) {
            overalappingIntervalEnd = endDate;
        }

    }

    public int getRr() {
        return rr;
    }

    public int getNap() {
        return nap;
    }

    
}
