package com.ssh.search;

/**
 * 线性查找
 *
 * @author: ssh
 * @email: 18367183519@163.com
 * @Date: 2020/6/7 0007 14:55
 */
public class SeqSearch {
    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 4, 7, -4, 9};
        int index = seqSearch(arr, 1);
        if (index == -1) {
            System.out.println("没找到");
        } else {
            System.out.println("找到，下标：" + index);
        }
    }

    private static int seqSearch(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
