package com.example.demandbase;

/**
 * Hello world!
 *
 *   1 -> 2 -> 3 -> 4 -> 5 -> 6->7
 * 
 *   1 6 2 5 3 4
 * 
 *   1 7 2 6 3 5 4
 * 
 *   
 *  1 2 3 4 5 6 7 - 
 * 
 *   
 *  slow pointer - 1 node 
 *  fast pointer - 2 node 
 * 
 * 
 *  
 *  
 *  
 *  
 * 
 * 
 */
public class App 
{
    public static void main( String[] args )
    {
       Node head = new Node(1);
       head.next = new Node(2);
       head.next.next = new Node(3);
       head.next.next.next = new Node(4);
       //head.next.next.next.next = new Node(5);

       PrintList pl = new PrintList();
       pl.printFirstLast(head);
    }
}
