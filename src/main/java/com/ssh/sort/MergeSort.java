package com.ssh.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 归并排序
 *
 * @author: ssh
 * @email: 18367183519@163.com
 * @Date: 2020/6/6 0006 23:37
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[80000];//合并次数=length-1
        int[] temp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(1000000);
        }
//        System.out.println("排序前:" + Arrays.toString(arr));
        long start = System.currentTimeMillis();
        mergeSort(arr,0,arr.length-1,temp);
        long end = System.currentTimeMillis();
        System.out.println("时间：" + (end - start) / 1000 + "秒");
//        System.out.println("排序后:" + Arrays.toString(arr));
    }

    /**
     * 分+合并
     * @param arr
     */
    private static void mergeSort(int[] arr, int left, int right, int[] temp){
        if (left < right){
            int mid = (left+right)/2;
            //向左递归
            mergeSort(arr,left,mid,temp);
            //向右递归
            mergeSort(arr,mid+1,right,temp);
            //合并方法
            merge(arr,left,mid,right,temp);
        }
    }

    /**
     * 合并方法
     * @param arr   原始数组
     * @param left  左边有序序列的初始索引
     * @param mid   中间索引
     * @param right 右边索引
     * @param temp  临时存放排序的数组
     */
    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;//临时存放排序的数组的索引
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        while (i <= mid) {//剩余元素填充到temp
            temp[t++] = arr[i++];
        }

        while (j <= right) {//剩余元素填充到temp
            temp[t++] = arr[j++];
        }

        //temp元素拷贝到arr
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right){
            arr[tempLeft++] = temp[t++];
        }
    }
}
