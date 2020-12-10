package com.ds.linkedlist;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class LinkedList {
    private static Node head;

    public static void main(String args[]) {
        LinkedList ll = new LinkedList();

        ll.head = new Node(1);
        /*Node second = new Node(2);
        Node third = new Node(3);
        ll.head.next = second;
        second.next = third;*/
        push(2);
        push(3);
        push(4);
        push(6);
        insertAfter(ll.head.next.next.next, 5);
        push(7);
        insertAtEnd(8);
        head.printList();

    }

    // insert At the front of the linked list
    static void push(int d) {
        Node n = new Node(d);
        n.next = head;
        head = n;
    }

    //add a node After a given node.
    static void insertAfter(Node prev_node, int d) {

        if (prev_node == null) {
            System.out.println("The given previous node cannot be null");
            return;
        }
        Node n = new Node(d);
        Node temp = prev_node.next;
        prev_node.next = n;
        n.next = temp;
        return;
    }

    //add a node at end
    static void insertAtEnd(int d) {
        Node n = new Node(d);
        if (head == null) {
            head = n;
            return;
        }
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = n;
        return;
    }

    // delete a key node
    static void deleteNode(int key) {
        //base case
        Node temp = head;
        Node prev = null;
        if (temp != null && temp.data == key) {
            Node n = temp.next;
            head = n;
            return;
        }
        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println(" No element found with the specified key");
            return;
        } else {
            prev.next = temp.next;
        }
    }

    // delete a node at specify position
    static void deleteNodeAtPos(int position) {
        Node n = head;
        Node next = null;
        // If linked list is empty
        if (n == null)
            return;
        // if we need to remove head
        if (position == 0) {
            head = n.next;   // Change head
            return;
        }

        for (int i = 0; n != null && i < position - 1; i++) {
            // prev=n;
            n = n.next;
        }

        if (n == null) {
            return;
        }
        // Node temp->next is the node to be deleted
        // Store pointer to the next of node to be deleted
        next = n.next.next;
        n.next = next;  // Unlink the deleted node from list
    }

    // size of linkedList using iterative
    static int getCount() {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    static int getCountRec(Node node) {

        // Base case
        if (node == null)
            return 0;
        return 1 + getCountRec(node.next);
    }

    /* Wrapper over getCountRec() */
    public int getCount1() {
        return getCountRec(head);
    }

    //seraching an element in LL in iterative method
    ////Checks whether the value x is present in linked list
    static boolean search(Node head, int key) {
        if (head == null)
            return false;

        Node temp = head;

        while (temp != null) {
            if (temp.data == key)
                return true;
            temp = temp.next;
        }
        return false;
    }

    // Search an element using recursive method
    static boolean searchRecursive(Node head, int key) {
        if (head == null)
            return false;
        if (head.data == key)
            return true;
        return searchRecursive(head.next, key);
    }

    //Get Nth node in LL
    static int getNth(Node head, int n) {
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (i == n) {
                return temp.data;
            }
            temp = temp.next;
        }
        //if nth index is not there then return o
        return 0;
    }

    //printNthFromLast
    static int printNthFromLast(Node head, int n) {
        Node temp = head;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        if (length < n)
            return 0;

        for (int i = 0; i < length - n + 1; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    //printMiddle
    static void printMiddle() {
        Node slow = head;
        Node fast = head;

        if (head == null)
            return;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println("Middle elemnt is " + slow.data);
    }

    //detectLoop using iterative method
    static boolean detectLoop(Node head) {
        boolean flag = false;
        HashSet<Integer> set = new HashSet<>();
        Node temp = head;
        while (temp != null) {
            if (set.contains(temp.data)) {
                flag = true;
            }
            set.add(temp.data);
            temp = temp.next;
        }
        return flag;
    }
    //detectLoop using two pointers method

    static boolean detectLoopUsingTwoPointers(Node head) {
        boolean flag = false;
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            if (slow == fast) {
                countNodes(slow);
                flag = true;
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return flag;
    }

    //Count the length of the loop
    static void countNodes(Node node) {
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }
        System.out.println("Length of the loop is  " + count);
    }

    //Reverse LL
    static Node reverseLL(Node head) {
        Node prev = null;
        Node curr = head;
        Node next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }

    //check pallindrom using stack
    static boolean isPalindrome(Node head) {
        boolean ispalin = false;
        Node temp = head;
        Stack<Integer> stack = new Stack<Integer>();
        while (temp != null) {
            stack.push(temp.data);
            temp = temp.next;
        }
        while (temp != null) {
            int i = stack.pop();
            if (i == temp.data) {
                ispalin = true;
            } else {
                ispalin = false;
                break;
            }
            temp = temp.next;
        }
        return ispalin;
    }

    //delete duplicate node in case of sorted LL
    static void removeDuplicateInSortedLL(Node head) {
        /*Another reference to head*/
        Node curr = head;

        /* Traverse list till the last node */
        while (curr != null) {
            Node temp = curr;
            /*Compare current node with the next node and
            keep on deleting them until it matches the current
            node data */
            while (temp != null && temp.data == curr.data) {
                temp = temp.next;
            }
            /*Set current node next to the next different
            element denoted by temp*/
            curr.next = temp;
            curr = curr.next;
        }
    }

    // remove duplicates in unsorted LL
    static void removeDuplicate(Node head) {
        HashSet<Integer> set = new HashSet<Integer>();
        Node curr = head;
        Node prev = null;
        while (curr != null) {
            if (set.contains(curr.data)) {
                prev = curr.next;
            } else {
                set.add(curr.data);
                prev = curr;
            }
            curr = curr.next;
        }
    }

    //Move last element to front of a given Linked List
    static void moveToFront(Node node) {
        //  1->2->3->4->5  to 5->1->2->3->4
        if (head == null || head.next == null)
            return;
        Node last = head;
        Node seclast = null;

        while (last.next != null) {
            seclast = last;
            last = last.next;
        }
        seclast = null;
        last.next = head;
        head = last;
    }


    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        static void printList() {
            Node n = head;
            while (n != null) {
                System.out.println(n.data + "");
                n = n.next;
            }
        }
    }
}
