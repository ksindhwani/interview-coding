package com.example.cleartrip;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Question1Test {
    Question1 question1;

    @Test
    public void testNRoomRequired() {

        int m = 7; // number of patients
        int n = 5; // no of rooms available
        Patient[] patients = new Patient[m];

        patients[0] = new Patient(4, 6);
        patients[1] = new Patient(4, 6);
        patients[2] = new Patient(7, 8);
        patients[3] = new Patient(7, 8);
        patients[4] = new Patient(4, 8);
        patients[5] = new Patient(4, 7);
        patients[6] = new Patient(8, 10);

         question1 = new Question1();
        question1.nRoomRequired(patients, n, m);

        // Compare Room Required
        assertEquals(4, question1.getRr());

        // Compare non accomdate patients
        assertEquals(0, question1.getNap());

    }

    @Test
    public void testNRoomRequiredWithNonAccomdatingPatients() {

        int m = 7; // number of patients
        int n = 3; // no of rooms available
        Patient[] patients = new Patient[m];

        patients[0] = new Patient(4, 6);
        patients[1] = new Patient(4, 6);
        patients[2] = new Patient(7, 8);
        patients[3] = new Patient(7, 8);
        patients[4] = new Patient(4, 8);
        patients[5] = new Patient(4, 7);
        patients[6] = new Patient(8, 10);

        question1 = new Question1();
        question1.nRoomRequired(patients, n, m);

        // Compare Room Required
        assertEquals(3, question1.getRr());

        // Compare non accomdate patients
        assertEquals(1, question1.getNap());

    }
}
