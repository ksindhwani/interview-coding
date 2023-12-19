package com.example.hellofresh.interview;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Least recent used cache but eviction should be based on the elment used less number of times
 *  
 * 
 * cache of size 3 - a b c  
 * 
 * a- 0
 * b- 0
 * c- 0
 * 
 * 
 * 
 *  c  a b c c b - read sequence 
 * 
 * a- 1
 * b- 2
 * c- 3
 * 
 * insert d , eviction should be a 
 * in case of same hits, evict any of them
 *  b c d 
 * 
 * insert e , evict d because d has 0 hits so far
 */

public class LRUCache2<String,V> {
    private Map<String, V> cache;
    private int capacity;
    private Map<String, Integer> hitCount;

    public LRUCache2(int capacity) {
        this.cache = new HashMap<>(capacity);
        this.hitCount = new HashMap<>();
        this.capacity = capacity;
    } 


    public void put(String key, V value) {
        if(cache.size() < capacity) {
            cache.put(key, value);
            hitCount.put(key , 0);
        } else {
            int min = Integer. MAX_VALUE;
            String minKey = null;
            for(String hitCountkey : hitCount.keySet()) {
                if (hitCount.get(hitCountkey) < min) {
                    minKey = hitCountkey;
                    min = hitCount.get(hitCountkey);
                }
            }
            cache.remove(minKey);
            cache.put(key, value);
            hitCount.put(key , 0);
        }
    }

    public void displayCache() {
        System.out.println("LRU [cache=" + cache + "]");
    }

    public V get(String key) throws Exception {
        if(cache.containsKey(key)) {
            hitCount.put(key, hitCount.get(key) + 1);
            return cache.get(key);
        }
        throw new Exception("Key is not present in the cache");
    }
}
