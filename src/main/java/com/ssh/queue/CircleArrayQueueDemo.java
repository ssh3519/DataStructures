package com.ssh.queue;

import java.util.Scanner;

/**
 * @author: ssh
 * @email: 18367183519@163.com
 * @Date: 2020/6/2 0002 19:09
 */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        //创建环形队列，有效数据最多为3
        CircleArray arrayQueue = new CircleArray(4);
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

class CircleArray{
    //最大容量
    private int maxSize;
    //指向队列的第一个元素，arr[front]
    private int front;
    //指向队列的最后一个元素的后一个位置
    private int rear;
    //存数据
    private int[] arr;

    public CircleArray(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    //判断队列是否满
    public boolean isFull(){
        return (rear+1)%maxSize == front;
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
        //直接加入
        arr[rear] = n;
        //后移取模
        rear = (rear+1)%maxSize;
    }

    //获取
    public int getQueue(){
        //判断是否空
        if (isEmpty()){
            throw new RuntimeException("队列为空");
        }
        int value = arr[front];
        front = (front+1)%maxSize;
        return value;
    }

    //显示队列所有数据
    public void showQueue(){
        //判断是否空
        if (isEmpty()){
            System.out.println("队列为空");
            return;
        }
        for (int i = front; i < front+size(); i++) {
            System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i]);
        }
    }

    //求出当前队列有效数据的个数
    public int size(){
        return (rear+maxSize-front)%maxSize;
    }

    //显示队列头数据
    public int headQueue(){
        //判断是否空
        if (isEmpty()){
            throw new RuntimeException("队列为空");
        }
        return arr[front];
    }
}
