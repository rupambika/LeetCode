package com.ds.stack;

public class ArrayStack {
    int MAX = 100;
    int top;
    int a[] = new int[MAX];

    public ArrayStack() {
        top = -1;
    }

    boolean isEmpty() {
        if (top < 0)
            return true;
        return false;
    }

    boolean push(int x) {
        if (top >= (MAX - 1)) {
            System.out.println("Stack Overflow");
            return false;
        } else {
            a[++top] = x;
            System.out.println(x + " pushed into stack");
            return true;
        }
    }

    int pop() {
        if (top < 0) {
            System.out.println("Stack Underflow");
            return 0;
        }
        return a[top--];
    }

    int peek() {
        if (top < 0) {
            System.out.println("Stack Underflow");
            return 0;
        }
        return a[top];
    }

    // Driver code
    static class Main {
        public static void main(String args[]) {
            ArrayStack s = new ArrayStack();
            s.push(10);
            s.push(20);
            s.push(30);
            System.out.println(s.pop() + " Popped from stack");
        }

    }
}