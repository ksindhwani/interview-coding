package com.example.epam.interview.model;

import java.util.HashSet;
import java.util.Set;

public class RepeatedCharacter {

    public char getFirstRepeatedCharacter(String str) {
        Set<Character> set = new HashSet<>();
        Character result = null;
        for(char c : str.toCharArray()) {
            if(!set.contains(c)) {
                set.add(c);
            } else {
                result = c;
                break;
            }
        }
        return result;
    }
}
