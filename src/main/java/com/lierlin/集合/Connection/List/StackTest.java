package com.lierlin.¼¯ºÏ.Connection.List;

import java.util.Stack;

public class StackTest {

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        System.out.println(stack.empty());
        System.out.println(stack.peek());
        System.out.println(stack.search("b"));
        System.out.println(stack.pop());
        System.out.println(stack);
    }

}
