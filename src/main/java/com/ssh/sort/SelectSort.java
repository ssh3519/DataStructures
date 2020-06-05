package com.ssh.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 选择排序
 * @author: ssh
 * @email: 18367183519@163.com
 * @Date: 2020/6/5 0005 22:17
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(1000000);
        }
        //        System.out.println("排序前:" + Arrays.toString(arr));
        long start = System.currentTimeMillis();
        selectSort(arr);
        long end = System.currentTimeMillis();
        System.out.println("时间："+(end-start) / 1000+"秒");
//        System.out.println("选择排序后:" + Arrays.toString(arr));
    }

    private static void selectSort(int[] arr) {
        int min;//最小值下标
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            min = i;
            for (int j = i+1; j < arr.length - 1; j++) {
                if (arr[j]<arr[min]){
                    min = j;
                }
            }
            if (min != i){//交换
                temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }
}
