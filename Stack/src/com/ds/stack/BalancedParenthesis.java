package com.ds.stack;

import java.util.Stack;

public class BalancedParenthesis {

    static boolean checkBalanced(String exp) {

        int len = exp.length();
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < len; i++) {
            char c = exp.charAt(i);
            if (c == '{' || c == '(' || c == '[') {
                stack.push(c);
                continue;
            } else {
                char pop = 0;
                if (!stack.isEmpty()) {
                    pop = stack.pop();
                }
                if ((c == '}') && pop == ')' || pop == ']') {
                    return false;
                }
                if ((c == ')') && pop == '}' || pop == ']') {
                    return false;
                }
                if ((c == ']') && pop == '}' || pop == ')') {
                    return false;
                }
            }
        }
         return (stack.isEmpty());
    }

    // Driver Code
    public static void main(String args[]) {
        String exp = "[()]{}{[()()]()}";
        System.out.println(checkBalanced(exp));
    }
}
