package com.ds.stack;

import java.util.Stack;

//Algorithm
//1. Scan the infix expression from left to right.
//2. If the scanned character is an operand, output it.
//3. Else,
//      1 If the precedence of the scanned operator is greater than the precedence of the operator in the stack(or the stack is empty
//      or the stack contains a ‘(‘ ), push it.
//      2 Else, Pop all the operators from the stack which are greater than or equal to in precedence than that of the scanned operator.
//      After doing that Push the scanned operator to the stack. (If you encounter parenthesis while popping then stop there and push the scanned operator in the stack.)
//4. If the scanned character is an ‘(‘, push it to the stack.
//5. If the scanned character is an ‘)’, pop the stack and and output it until a ‘(‘ is encountered, and discard both the parenthesis.
//6. Repeat steps 2-6 until infix expression is scanned.
//7. Print the output
//8. Pop and output from the stack until it is not empty.

public class InfixToPostfix {

    static int checkPrecedence(char c) {
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
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    static String infixToPostfix(String str) {
        int len = str.length();
        String postFix = "";
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < len; ++i) {
            char c = str.charAt(i);

            if (isOperand(c))
                postFix += c;

            else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() &&
                        stack.peek() != '(')
                    postFix += stack.pop();

                stack.pop();

            } else {
                while (!stack.isEmpty() && checkPrecedence(c) <= checkPrecedence(stack.peek())) {
                    postFix += stack.pop();
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            if (stack.peek() == '(')
                return "Invalid Expression";
            postFix += stack.pop();
        }
        return postFix;
    }

    // Driver method
    public static void main(String[] args) {
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infixToPostfix(exp));
    }
}
