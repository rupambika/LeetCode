package com.ds.stack;

import java.util.Stack;

public class PostfixToInfix {

    static boolean checkOperand(char c) {
        return (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z');
    }

    static String postfixToInfix(String str) {
        Stack<String> stack = new Stack<String>();
        String result = "";
        int len = str.length();
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);

            if (checkOperand(c))
                stack.push(c + "");
            else {
                String op1 = stack.pop();
                String op2 = stack.pop();

                result = "(" + op2 + c + op1 + ")";
                stack.push(result);
            }
        }
        return stack.peek();
    }

    // Driver method
    public static void main(String[] args) {
        //String exp = "ab*c+";
        String exp = "abcd^e-fgh*+^*+i-";
        System.out.println(postfixToInfix(exp));
    }
}
