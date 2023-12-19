package com.example.amazon;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MaxOfMinima {

    public int segment(int x , List<Integer> arr) {

        List<Integer> minArray = new ArrayList<>();

        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < x; i++) {
            while (!deque.isEmpty() && arr.get(i) <= arr.get(deque.peekLast())) {
                deque.removeLast();
            }
            deque.addLast(i);
        }


        for (int i = x; i < arr.size(); i++) {
            minArray.add(arr.get(deque.peekFirst()));

            while (!deque.isEmpty() && deque.peekFirst() <= i - x) {
                deque.removeFirst();
            }

            while (!deque.isEmpty() && arr.get(i) <= arr.get(deque.peekLast())) {
                deque.removeLast();
            }

            deque.addLast(i);
        }

        minArray.add(arr.get(deque.peekFirst()));

        int MAX_VALUE = Integer.MIN_VALUE;

        for(int i = 0 ;i< minArray.size();i++) {
            if (minArray.get(i) > MAX_VALUE) {
                MAX_VALUE = minArray.get(i);
            }
        }

        return MAX_VALUE;

    }
    
}
