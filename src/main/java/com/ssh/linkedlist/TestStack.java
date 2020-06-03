package com.ssh.linkedlist;

import java.util.Stack;

/**
 * 栈测试
 * @author: ssh
 * @email: 18367183519@163.com
 * @Date: 2020/6/3 0003 10:49
 */
public class TestStack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
