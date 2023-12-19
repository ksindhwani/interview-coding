package com.example.cleartrip;

/**
 * 
 * {[0,1],[0,2],[3,4],[4,5]}
 * 
 * parent Array- 
 * 
 * 0 0 0 3 3 3  - inital input
 * 
 * 
 * 
 * 5 vertices - 
 * 
 * 
 * 
 * 
 * 
 * Solution-- 
 * 
 * Solution - Find the number of disjoint sets in the given edges 
 * 
 * Steps
 * 
 * 1. Take intial parent array and make each vertices their own parent
 * 
 *           For above Example
 * 
 *          Parent Array
 * 
 *           p = 0 1 2 3 4 5
 * 
 * 2. Scan the edges and update the parent of vertices from to the ones they are reachable 
 *  
 *          So if edge is [0,1] then parent of 1 is 0 becuase 1 is reachable from 0
 * 
 *          For above example parent array be 
 * 
 *           p = 0 0 0 3 3 3
 * 
 * 3. Scan the parent arrray and change the parent of vertices to their origin vertex as parent 
 * 
 *      For example if we have edges as [0,1] , [0,2] and [2,7]
 * 
 *      So 7 is reachable from 2 so we need to update parent of 7 as 2
 * 
 *      *** This was the part which i was unable to code in the interview because of time crunch and need simple google search ****
 * 
 * 
 * 4. Find the unique values from the parent array and return it as answer
 * 
 */
public class Question2 {
    
}
