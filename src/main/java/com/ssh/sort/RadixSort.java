package com.ssh.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 基数排序(空间换时间)
 *
 * @author: ssh
 * @email: 18367183519@163.com
 * @Date: 2020/6/7 0007 13:17
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(1000000);
        }
//        int[] arr = {53, 3, 542, 748, 14, 214};
//        System.out.println("排序前:" + Arrays.toString(arr));
        long start = System.currentTimeMillis();
        radixSort(arr);
        long end = System.currentTimeMillis();
        System.out.println("时间：" + (end - start) / 1000 + "秒");
//        System.out.println("排序后:" + Arrays.toString(arr));
    }

    private static void radixSort(int[] arr) {
        //得到数组中最大数的位数
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        //最大位数
        int maxLength = String.valueOf(max).length();
        for (int k = 0, n = 1; k < maxLength; k++, n *= 10) {
            //定义一个二维数组，表示10个桶，每个桶就是一个维数组
            int[][] bucket = new int[10][arr.length];
            //为了记录每个桶中，实际存放多少数据，定义一个一维数组，记录各个桶每次放入的数据个数
            int[] bucketElementCounts = new int[10];

            int digitOfElement;

            //存入每个桶中
            for (int i = 0; i < arr.length; i++) {
                digitOfElement = arr[i] / n % 10;
                bucket[digitOfElement][bucketElementCounts[digitOfElement]++] = arr[i];
            }

            int index = 0;
            //遍历桶
            for (int i = 0; i < bucketElementCounts.length; i++) {
                if (bucketElementCounts[i] != 0) {
                    for (int j = 0; j < bucketElementCounts[i]; j++) {
                        arr[index++] = bucket[i][j];
                    }
                }
                //将桶清空
                bucketElementCounts[i] = 0;
            }
//            System.out.println("第"+(k+1)+"轮，排序："+Arrays.toString(arr));
        }

    }


}
