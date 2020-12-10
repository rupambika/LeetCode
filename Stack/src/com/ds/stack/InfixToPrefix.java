package com.ds.stack;
//Step 1: Reverse the infix expression i.e A+B*C will become C*B+A.
// Note while reversing each ‘(‘ will become ‘)’ and each ‘)’ becomes ‘(‘.
//Step 2: Obtain the postfix expression of the modified expression i.e CB*A+.
//Step 3: Reverse the postfix expression. Hence in our example prefix is +A*BC.

import java.util.Stack;

public class InfixToPrefix {
    static int isPrecendence(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '/':
            case '*':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    static boolean isOperand(char c) {

        return (c >= 'a' && c <= 'z') && (c >= 'A' || c <= 'Z');
    }

    static String infixToPrefix(String str) {

        int len = str.length();
        Stack<Character> stack = new Stack<Character>();
        String result = "";
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            if (isOperand(c))
                result += c;
            else if (c == ')') {
                stack.push(c);
            } else if (c == '(') {
                while (!stack.isEmpty() && stack.peek() != ')')
                    result += stack.pop();
                stack.pop();
            } else {
                while (!stack.isEmpty() && isPrecendence(c) < isPrecendence(stack.peek())) {
                    result += stack.pop();
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            if (stack.peek() == ')')
                return "Invalid Expression";
            result += stack.pop();
        }

        return result;
    }


    // Driver method
    public static void main(String[] args) {
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        StringBuilder sb = new StringBuilder(exp);
        String reverse = sb.reverse().toString();
        System.out.println(infixToPrefix(reverse));
        StringBuilder postfix = new StringBuilder(infixToPrefix(reverse));
        String infix = postfix.reverse().toString();
        System.out.println("convert: " + infix);
    }
}
