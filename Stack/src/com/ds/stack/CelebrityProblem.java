package com.ds.stack;

import java.util.Stack;

public class CelebrityProblem {

    // Java program to find celebrity using stack data structure
    // Person with 2 is celebrity
    //                              A             B             C             D
    static int MATRIX[][] = {{0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}, {0, 0, 1, 0}};

    // Returns true if a knows
    // b, false otherwise
    static boolean knows(int a, int b) {
        boolean res = (MATRIX[a][b] == 1) ? true : false;
        return res;
    }

    // Returns -1 if celebrity
    // is not present. If present,
    // returns id (value from 0 to n-1).
    static int findCelebrity(int n) {
        Stack<Integer> st = new Stack<>();
        int pot = 0;
        //first push all the elements.. i.e A, B, C,D in stack
        for (int i = 0; i < n; i++) {
            st.push(i);
        }

        while (st.size() >= 2) {
            int a = st.pop();
            int b = st.pop();

            if (knows(a, b)) {
                st.push(b);
            } else {
                st.push(a);
            }
        }
        pot = st.pop();
        for (int j = 0; j < n; j++) {
            if ((j != pot) && (MATRIX[pot][j]) == 1) {
                return -1;
            }
        }
        return pot;
    }

    // Driver Code
    public static void main(String[] args) {
        int n = 4;
        int result = findCelebrity(n);
        if (result == -1) {
            System.out.println("No Celebrity");
        } else
            System.out.println("Celebrity ID " +
                    result);
    }
}




