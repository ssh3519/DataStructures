package com.ssh.recursion;

/**
 * 递归-八皇后问题
 *
 * @author: ssh
 * @email: 18367183519@163.com
 * @Date: 2020/6/4 0004 21:57
 */
public class Queen8 {
    //定义一共8个皇后
    int max = 8;
    //定义数组，保存皇后放置位置的结果，比如arr = {0,4,7,5,2,6,1,3}
    int[] arr = new int[max];

    static int count = 0;
    static int judgeCount = 0;
    public static void main(String[] args) {
        Queen8 queen8 = new Queen8();
        queen8.check(0);
        System.out.printf("一共有%d种解法\r\n",count);
        System.out.printf("一共判断冲突%d次\r\n",judgeCount);
    }

    //放置第n个皇后
    private void check(int n) {
        if (n == max) {
            print();
            return;
        }
        //依次放入皇后，判断
        for (int i = 0; i < max; i++) {
            //先把当前这个皇后放到第一列
            arr[n] = i;
            //判断当放置第n个皇后到i列时，是否冲突
            if (judge(n)) {//不冲突
                //接着放n+1个皇后
                check(n + 1);
            }
        }
    }

    //判断第n个皇后是否冲突
    private boolean judge(int n) {
        judgeCount++;
        for (int i = 0; i < n; i++) {
            //列相同 || 同一斜线上 || 同一行
            if (arr[i] == arr[n] || Math.abs(n - i) == Math.abs(arr[n] - arr[i])) {
                return false;
            }
        }
        return true;
    }

    private void print() {
        count++;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
