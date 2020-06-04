package com.ssh.recursion;

/**
 * @author: ssh
 * @email: 18367183519@163.com
 * @Date: 2020/6/4 0004 15:30
 */
public class RecursionTest {
    public static void main(String[] args) {
        test(4);
        System.out.println(factorial(3));
    }

    //打印问题
    public static void test(int n) {
        if (n > 2) {
            test(n - 1);
        }
        System.out.println("n=" + n);
    }
    //阶乘问题
    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return factorial(n - 1) * n;
        }
    }
}
