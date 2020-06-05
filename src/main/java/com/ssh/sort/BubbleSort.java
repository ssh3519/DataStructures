package com.ssh.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 冒泡排序
 *
 * @author: ssh
 * @email: 18367183519@163.com
 * @Date: 2020/6/5 0005 21:35
 */
public class BubbleSort {
    public static void main(String[] args) {
//        int[] arr = {2, 4, 1, 6, 7, 3};
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(1000000);
        }
//        System.out.println("排序前:" + Arrays.toString(arr));
        long start = System.currentTimeMillis();
        bubbleSort(arr);
        long end = System.currentTimeMillis();
        System.out.println("时间："+(end-start) / 1000+"秒");
//        System.out.println("冒泡排序后:" + Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr){
        int temp = 0;
        boolean flag = false;//表示是否交换
        for (int i = 0; i < arr.length - 1; i++) {
            flag = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!flag){//没交换
                break;
            }
//            System.out.println("第"+(i+1)+"趟排序");
//            System.out.println(Arrays.toString(arr));
        }
    }
}
