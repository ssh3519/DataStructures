package com.ssh.linkedlist;

/**
 * 约瑟夫问题
 * @author: ssh
 * @email: 18367183519@163.com
 * @Date: 2020/6/3 0003 15:56
 */
public class Josephu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.showBoy();
        System.out.println("出圈顺序-----------------------");
        circleSingleLinkedList.countBoy(1,2,5);
    }
}

//创建环形单向链表
class CircleSingleLinkedList {
    //创建一个first节点，没有编号
    private Boy first = null;

    //添加节点，构成环形链表
    public void addBoy(int nums) {
        if (nums < 1) {
            System.out.println("nums错误");
            return;
        }
        //辅助指针，帮助构建环形链表
        Boy curBoy = null;
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            if (i == 1) {
                //让first指向该节点
                first = boy;
                //构成环
                first.setNext(first);
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    //遍历环形链表
    public void showBoy() {
        //判断链表是否为空
        if (first == null) {
            System.out.println("链表为空");
            return;
        }
        Boy temp = first;
        while (true) {
            System.out.printf("编号%d\n", temp.getNo());
            if (temp.getNext() == first) {
                //遍历完
                break;
            }
            //后移
            temp = temp.getNext();
        }
    }

    //根据用户的输入，计算顺序

    /**
     * @param startNo  表示从第几个开始
     * @param countNum 表示数几下
     * @param nums     表示初始数量
     */
    public void countBoy(int startNo, int countNum, int nums) {
        if (first == null || startNo < 1 || startNo > nums){
            System.out.println("参数错误");
            return;
        }
        //创建辅助指针
        Boy helper = first;
        //初始化使helper指向环形链表最后一个节点
        while (true){
            if (helper.getNext() == first){
                break;
            }
            helper = helper.getNext();
        }
        //报数前，让first和helper同时移动startNo - 1次
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        //报数时，first和helper同时移动countNum - 1次，然后出圈；
        while (true){
            if (helper == first){
                //说明圈中只有一个
                break;
            }
            //first和helper同时移动countNum - 1次，
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.printf("出圈编号%d\n",first.getNo());
            //first指向出圈节点
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后出圈编号%d\n",first.getNo());
    }
}

//创建节点
class Boy {
    private int no;//编号
    private Boy next;//指向下一个节点，默认null

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
