package com.bala.hackerrank;

import java.util.Stack;

public class JavaBraces {

    static String isBalanced(String s)
    {
        char [] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for( char c : arr){
            if(c == '{') {
                stack.push('}');
            } else if( c == '(') {
                stack.push(')');
            } else {
                if(stack.isEmpty() || c !=stack.peek()){
                    return "false";
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty() ? "true" : "false";
    }
}
