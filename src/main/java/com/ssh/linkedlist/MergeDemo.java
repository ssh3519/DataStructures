package com.ssh.linkedlist;

/**
 * 两个有序链表合并
 * @author: ssh
 * @email: 18367183519@163.com
 * @Date: 2020/6/3 0003 13:08
 */
public class MergeDemo {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node1.next = node3;
        node3.next = node5;
        node2.next = node4;
        Node node = mergeTwoList2(node1, node2);
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static Node mergeTwoList(Node head1, Node head2) {
        if (head1 == null && head2 == null) {
            return null;
        }
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        Node head = null;
        if (head1.data <= head2.data) {
            head = head1;
            System.out.println(head);
            head.next = mergeTwoList(head1.next, head2);
        } else {
            head = head2;
            System.out.println(head);
            head.next = mergeTwoList(head1, head2.next);
        }
        return head;
    }

    public static Node mergeTwoList2(Node head1, Node head2) {
        Node node = new Node(0);
        Node cur = node;
        while (true) {
            if (head1 == null && head2 == null) {
                break;
            } else if (head1 != null && head2 == null) {
                cur.next = head1;
                break;
            } else if (head1 == null && head2 != null) {
                cur.next = head2;
                break;
            } else if (head1.data <= head2.data) {
                cur.next = head1;
                head1 = head1.next;
            } else {
                cur.next = head2;
                head2 = head2.next;
            }
            cur=cur.next;
        }
        return node.next;
    }
}

class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}
