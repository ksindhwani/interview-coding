package com.example.demandbase;


class Node {
    public int data;
    public Node next;

    public Node() {}

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class PrintList {

    public void printFirstLast(Node head) {
        if(head == null) {
            return;
        } else if (head.next == null) {
            printList(head);
        } else {
            Node slow = head;
            Node fast = head;

            while(fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            Node reverse = reverseList(slow.next);
            slow.next = null;

            // printing reverse part
            System.out.println("Reverse");
            printList(reverse);
             System.out.println("Reverse end");


             Node temp1 = head;
             Node temp2 = reverse;


            while(temp1 != null && temp2 != null) {
                System.out.println(temp1.data);
                System.out.println(temp2.data);
                temp1 = temp1.next;
                temp2 = temp2.next;
            }

            if(temp1 != null) {
                printList(temp1);
            }
            if (temp2 != null) {
                printList(temp2);
            }
        }
    }

    private Node reverseList(Node head) {
        if(head == null || head.next == null) {
            return head;
        } else {
            Node reverseNode = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return reverseNode;
        }

    }

    public void printList(Node head) {
        Node temp = head;
        while(temp!=null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
