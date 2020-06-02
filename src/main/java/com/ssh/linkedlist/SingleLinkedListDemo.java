package com.ssh.linkedlist;

/**
 * @author: ssh
 * @email: 18367183519@163.com
 * @Date: 2020/6/2 0002 20:49
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode heroNode1 = new HeroNode(1,"a","aaa");
        HeroNode heroNode2 = new HeroNode(2,"b","bbb");
        HeroNode heroNode3 = new HeroNode(3,"c","ccc");
        HeroNode heroNode4 = new HeroNode(4,"d","ddd");
        HeroNode heroNode5 = new HeroNode(3,"c3","c3");
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addByOrder(heroNode2);
        singleLinkedList.addByOrder(heroNode1);
        singleLinkedList.addByOrder(heroNode4);
        singleLinkedList.addByOrder(heroNode3);
        singleLinkedList.list();
        singleLinkedList.update(heroNode5);
        System.out.println("修改之后----------------------------------");
        singleLinkedList.list();
        System.out.println("删除之后----------------------------------");
        singleLinkedList.delete(1);
        singleLinkedList.list();
    }
}

//定义SingleLinkedList管理节点
class SingleLinkedList{
    //初始化一个头结点
    private HeroNode head = new HeroNode(0,"","");

    //添加节点
    //1.找到当前链表的最后节点
    //2.将这个节点的next指向新节点
    public void add(HeroNode heroNode){
        //head节点不能变，需要一个辅助变量temp
        HeroNode temp = head;
        while (true){
            //找到链表最后
            if (temp.next == null){
                break;
            }
            //没找到后移
            temp = temp.next;
        }
        //最后节点的next指向新节点
        temp.next = heroNode;
    }

    //遍历链表
    public void list(){
        //判断链表是否为空
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        //head节点不能，需要一个辅助变量temp
        HeroNode temp = head.next;
        while (true){
            //判断是否到链表最后
            if (temp==null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    //根据no插入
    //因为单链表，找的temp位于新节点前
    public void addByOrder(HeroNode heroNode){
        //head节点不能变，需要一个辅助变量temp
        HeroNode temp = head;
        boolean flag = false;//添加的no是否存在，默认false
        while (true){
            if (temp.next == null){//说明temp已到达链表尾部
                break;
            }else if (temp.next.no > heroNode.no){//位置找到
                break;
            }else if (temp.next.no == heroNode.no){//no存在
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            System.out.println("no不能重复");
        }else{
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    //修改节点，根据no
    public void update(HeroNode newHeroNode){
        //判断链表是否为空
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;//修改的no是否存在，默认false
        while (true){
            if (temp==null){
                break;
            }else if (temp.no == newHeroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
        }else {
            System.out.println("没有找到");
        }
    }

    public void delete(int no){
        HeroNode temp = head;
        boolean flag = false;//删除的no是否存在，默认false
        while (true){
            if (temp.next == null){
                break;
            }
            if (temp.next.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag){
            //删除
            temp.next = temp.next.next;
        }else {
            System.out.println("没有找到");
        }
    }
}

//定义节点
class HeroNode{
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;//指向下一个节点

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
