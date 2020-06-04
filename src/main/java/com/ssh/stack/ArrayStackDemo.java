package com.ssh.stack;

import java.util.Scanner;

/**
 * @author: ssh
 * @email: 18367183519@163.com
 * @Date: 2020/6/3 0003 21:48
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(4);
        String key = "";
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while (loop){
            System.out.println("(show):显示栈");
            System.out.println("(push):入栈");
            System.out.println("(pop):出栈");
            System.out.println("(exit):退出");
            key = scanner.next();
            switch (key){
                case "show":
                    stack.list();
                    break;
                case "push":
                    System.out.println("输入一个数字：");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    int val = 0;
                    try {
                        val = stack.pop();
                        System.out.println("出栈："+val);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop=false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("退出----------------------");

    }
}

//表示栈
class ArrayStack {
    private int maxSize;//栈大小
    private int[] stack;//数组模拟栈
    private int top = -1;//top表示栈顶，初始化-1

    //构造器
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //栈是否满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //栈是否空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈
    public void push(int val){
        //栈满
        if (isFull()){
            System.out.println("栈已满");
            return;
        }
        stack[++top] = val;
    }

    //出栈
    public int pop(){
        //栈空
        if (isEmpty()){
            throw new RuntimeException("栈空");
        }
        int val = stack[top];
        top--;
        return val;
    }

    //遍历栈，从栈顶开始
    public void list(){
        //栈空
        if (isEmpty()){
            System.out.println("栈空");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }
    }
}
