package com.example.hellofresh.interview;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Least recent used cache
 *  
 * 
 * cache of size 3 - a b c  
 *  c  b a - read sequence 
 * insert d 
 * 
 * remove c
 * 
 * LinkedHashMap cache of size 3
 * 
 *  a b d     
 * 
 * 
 */
public class LRU<String,V> {
    private Map<String, V> cache;
    private int capacity;

    public LRU(int capacity) {
        this.cache = new LinkedHashMap<>(capacity);
        this.capacity = capacity;
    } 

    public void put(String key, V value) {
        if(cache.size() < capacity) {
            cache.put(key, value);
        } else {
            Map.Entry<String,V> entry = cache.entrySet().iterator().next();
            String firstKey = entry.getKey();
            cache.remove(firstKey);
            cache.put(key, value);
        }
    }


    public void displayCache() {
        System.out.println("LRU [cache=" + cache + "]");
    }

    public V get(String key) throws Exception {
        if(cache.containsKey(key)) {
            V value = cache.get(key);
            cache.remove(key);
            cache.put(key, value);
            return value;
        }
        throw new Exception("Key is not present in the cache");
    }
}
