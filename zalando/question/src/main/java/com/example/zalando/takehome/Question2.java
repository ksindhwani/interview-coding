package com.example.zalando.takehome;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Question2 {
    public void solution(String S) {
        String[] stringArray = S.split("CD");
        String mergedString = Arrays.stream(stringArray).collect(Collectors.joining());
        System.out.println(mergedString);
    }
}
