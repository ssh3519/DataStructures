package com.ssh.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 希尔排序
 *
 * @author: ssh
 * @email: 18367183519@163.com
 * @Date: 2020/6/6 0006 16:25
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(1000000);
        }
//        System.out.println("排序前:" + Arrays.toString(arr));
        long start = System.currentTimeMillis();
        shellSort2(arr);
        long end = System.currentTimeMillis();
        System.out.println("时间：" + (end - start) / 1000 + "秒");
        System.out.println("排序后:" + Arrays.toString(arr));
    }


    //交换法
    private static void shellSort(int[] arr) {
        int temp;
//        int count = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
//            System.out.println("希尔排序第" + (++count) + "次：" + Arrays.toString(arr));
        }
    }

    //移位法
    private static void shellSort2(int[] arr) {
        int temp;
        int j;
//        int count = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                j = i;
                temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        //后移
                        arr[j] = arr[j - gap];
                        //往前遍历
                        j -= gap;
                    }
                    //插入
                    arr[j] = temp;
                }
            }
//            System.out.println("希尔排序第" + (++count) + "次：" + Arrays.toString(arr));
        }
    }
}
