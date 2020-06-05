package com.ssh.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author: ssh
 * @email: 18367183519@163.com
 * @Date: 2020/6/5 0005 22:39
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(1000000);
        }
                System.out.println("排序前:" + Arrays.toString(arr));
        long start = System.currentTimeMillis();
        insertSort(arr);
        long end = System.currentTimeMillis();
        System.out.println("时间："+(end-start) / 1000+"秒");
//        System.out.println("选择排序后:" + Arrays.toString(arr));
    }

    private static void insertSort(int[] arr) {
        int insertIndex;
        int insertValue;
        for (int i = 1; i < arr.length; i++) {
            insertIndex = i-1;//获取前面的下标
            insertValue = arr[i];
            while (insertIndex >= 0 && insertValue<arr[insertIndex]){
                arr[insertIndex+1] = arr[insertIndex];
                insertIndex--;
            }
//            System.out.println("第"+(i)+"趟排序");
//            System.out.println(Arrays.toString(arr));
            //插入位置
            if (insertIndex+1 != i){
                arr[insertIndex+1] = insertValue;
            }

        }
//        System.out.println(Arrays.toString(arr));
    }
}
