package com.example.hellofresh.interview;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        LRUCache2<String, Integer> cache = new LRUCache2<>(3);

        cache.put("a", 1);
        cache.put("b", 2);
        cache.put("c", 3);

        cache.displayCache();

        System.out.println("Key = c , Value = " + cache.get("c"));
        System.out.println("Key = a , Value = " + cache.get("a"));
        System.out.println("Key = b , Value = " + cache.get("b"));
        System.out.println("Key = c , Value = " + cache.get("c"));
        System.out.println("Key = c , Value = " + cache.get("c"));
        System.out.println("Key = b , Value = " + cache.get("b"));

        cache.put("d", 4);

        cache.displayCache();
    }
}
