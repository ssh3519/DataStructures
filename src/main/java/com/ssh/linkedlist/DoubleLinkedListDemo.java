package com.ssh.linkedlist;

/**
 * @author: ssh
 * @email: 18367183519@163.com
 * @Date: 2020/6/3 0003 14:08
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode2 heroNode1 = new HeroNode2(1,"a","aaa");
        HeroNode2 heroNode2 = new HeroNode2(2,"b","bbb");
        HeroNode2 heroNode3 = new HeroNode2(3,"c","ccc");
        HeroNode2 heroNode4 = new HeroNode2(4,"d","ddd");
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(heroNode1);
//        doubleLinkedList.add(heroNode2);
        doubleLinkedList.add(heroNode3);
        doubleLinkedList.add(heroNode4);
        doubleLinkedList.list();

        HeroNode2 heroNode5 = new HeroNode2(3,"c3","c3");
        doubleLinkedList.update(heroNode5);
        System.out.println("修改之后------------------------");
        doubleLinkedList.list();

        doubleLinkedList.delete(2);
        System.out.println("删除之后------------------------");
        doubleLinkedList.list();

        doubleLinkedList.addByOrder(heroNode2);
        System.out.println("插入之后------------------------");
        doubleLinkedList.list();
    }
}

//创建一个双向链表的类
class DoubleLinkedList {
    private HeroNode2 head = new HeroNode2(0, "", "");

    public HeroNode2 getHead() {
        return head;
    }

    //遍历双向链表
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
        }
        HeroNode2 temp = head.next;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    //添加节点
    public void add(HeroNode2 heroNode2) {
        HeroNode2 temp = head;
        while (true) {
            if (temp.next==null){
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode2;
        heroNode2.pre = temp;
    }
    //添加节点
    public void addByOrder(HeroNode2 heroNode2) {
        HeroNode2 temp = head;
        boolean flag = false;//添加的no是否存在，默认false
        while (true) {
            if (temp.next==null){
                break;
            }else if(temp.next.no>heroNode2.no){
                //找到
                break;
            }else if (temp.next.no==heroNode2.no){
                //重复
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            System.out.println("no不能重复");
        }else{
            heroNode2.next = temp.next;
            temp.next.pre=heroNode2;
            temp.next=heroNode2;
            heroNode2.pre=temp;
        }
    }

    //修改
    public void update(HeroNode2 newHeroNode){
        //判断链表是否为空
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
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

    //删除节点
    public void delete(int no){
        //判断链表是否为空
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;
        while (temp!=null){
            if (temp.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            //删除
            temp.pre.next = temp.next;
            //如果是最后一个节点，不需要执行下面，否则空指针
            if (temp.next != null){
                temp.next.pre = temp.pre;
            }
        }else {
            System.out.println("没有找到");
        }
    }
}

class HeroNode2 {
    public int no;
    public String name;
    public String nickName;
    public HeroNode2 next;//指向下一个节点，默认为null
    public HeroNode2 pre;//指向前一个节点，默认为null

    public HeroNode2(int no, String name, String nickName) {
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

