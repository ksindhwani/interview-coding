package com.example.demandbase;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    Map<String, Integer> cache;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new LinkedHashMap<>(capacity);
    }
    
    public void put(String key, int value);
    public Integer get(String key);


}
