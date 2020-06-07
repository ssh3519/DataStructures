package com.ssh.search;

import java.util.ArrayList;
import java.util.List;

/**
 * 二分查找
 *
 * @author: ssh
 * @email: 18367183519@163.com
 * @Date: 2020/6/7 0007 15:10
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6, 6, 6, 23, 53, 546};
/*        int index = binarySearch(arr, 0, arr.length, 6);
        if (index == -1) {
            System.out.println("没找到");
        } else {
            System.out.println("找到，下标：" + index);
        }*/
        List<Integer> list = binarySearch2(arr, 0, arr.length, 6);
        if (list.isEmpty()) {
            System.out.println("没找到");
        } else {
            System.out.println("找到，下标：" + list);
        }
    }

    //递归查找
    private static int binarySearch(int[] arr, int left, int right, int value) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (value < arr[mid]) {
            //左递归
            return binarySearch(arr, left, mid - 1, value);
        } else if (value > arr[mid]) {
            //右递归
            return binarySearch(arr, mid + 1, right, value);
        } else {
            return mid;
        }
    }

    //查出所有下标
    private static List<Integer> binarySearch2(int[] arr, int left, int right, int value) {
        if (left > right) {
            return new ArrayList<Integer>();
        }
        int mid = (left + right) / 2;
        if (value < arr[mid]) {
            //左递归
            return binarySearch2(arr, left, mid - 1, value);
        } else if (value > arr[mid]) {
            //右递归
            return binarySearch2(arr, mid + 1, right, value);
        } else {
            List<Integer> list = new ArrayList<>();
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != value) {
                    break;
                }
                list.add(temp);
                temp-=1;
            }
            list.add(mid);
            temp = mid + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != value) {
                    break;
                }
                list.add(temp);
                temp+=1;
            }
            return list;
        }
    }

    //非递归查找
    private static int binarySearch(int[] arr, int value) {
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (value < arr[mid]) {
                right = mid - 1;
            } else if (value > arr[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


}
