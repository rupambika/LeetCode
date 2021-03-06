package com.ds.stack;

import java.util.Stack;

public class PrefixToInfix {

    static boolean checkOperand(char c) {

        return (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z');
    }

    static String prefixToInfix(String str) {

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

                result = "(" + op1 + c + op2 + ")";
                stack.push(result);
            }
        }
        return stack.peek();
    }


    // Driver method
    public static void main(String[] args) {
        String exp = "*-A/BC-/AKL";
        StringBuilder sb = new StringBuilder(exp);
        System.out.println(prefixToInfix(sb.reverse().toString()));
    }
}
