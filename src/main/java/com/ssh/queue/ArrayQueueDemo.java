package com.ssh.queue;

import java.util.Scanner;

/**
 * @author: ssh
 * @email: 18367183519@163.com
 * @Date: 2020/6/2 0002 15:54
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop){
            System.out.println("s(show):显示队列");
            System.out.println("a(add):添加");
            System.out.println("g(get):取出");
            System.out.println("h(head):查看队头");
            System.out.println("e(exit):退出");
            key = scanner.next().charAt(0);
            switch (key){
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数字：");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = arrayQueue.getQueue();
                        System.out.println("取出的数据："+res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = arrayQueue.headQueue();
                        System.out.println("队列头的数据："+res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop=false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("结束-------------");
    }
}

//使用数组模拟队列-ArrayQueue类
class ArrayQueue{
    //最大容量
    private int maxSize;
    //队列头
    private int front;
    //队列尾
    private int rear;
    //存数据
    private int[] arr;

    //队列构造器
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;//指向队列头部，分析出front是指向队列头的前一个位置
        rear = -1;//指向队列尾部，指向队列尾的数据（即队列最后一个数据）
    }
    //判断队列是否满
    public boolean isFull(){
        return rear == maxSize-1;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }

    //添加
    public void addQueue(int n){
        //判断是否满
        if (isFull()) {
            System.out.println("队列已满");
            return;
        }
        arr[++rear] = n;
    }

    //获取
    public int getQueue(){
        //判断是否空
        if (isEmpty()){
            throw new RuntimeException("队列为空");
        }
        return arr[++front];
    }

    //显示队列所有数据
    public void showQueue(){
        //判断是否空
        if (isEmpty()){
            System.out.println("队列为空");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }

    //显示队列头数据
    public int headQueue(){
        //判断是否空
        if (isEmpty()){
            throw new RuntimeException("队列为空");
        }
        return arr[front+1];
    }
}
