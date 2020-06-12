package com.ssh.search;

/**
 * 插值查找
 *
 * @author: ssh
 * @email: 18367183519@163.com
 * @Date: 2020/6/7 0007 17:03
 */
public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        int index = inseartValueSearch(arr, 0, arr.length - 1, 4);
        System.out.println(index);
    }

    public static int inseartValueSearch(int[] arr, int left, int right, int findValue) {
        if (left > right || findValue < arr[0] || findValue > arr[right]) {
            return -1;
        }
        //公式
        int mid = left + (right - left) * (findValue - arr[left]) / (arr[right] - arr[left]);
        int midValue = arr[mid];
        if (findValue < midValue) {
            //左递归
            return inseartValueSearch(arr, left, mid - 1, findValue);
        } else if (findValue > midValue) {
            //左递归
            return inseartValueSearch(arr, mid + 1, right, findValue);
        } else {
            return mid;
        }
    }
}
