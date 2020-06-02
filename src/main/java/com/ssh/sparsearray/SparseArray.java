package com.ssh.sparsearray;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.io.*;

/**
 * @author: ssh
 * @email: 18367183519@163.com
 * @Date: 2020/6/2 0002 13:46
 */
public class SparseArray {
    public static void main(String[] args) throws Exception {
        //创建一个原始的二维数组11*11
        //0:无棋子 1：黑子 2：白子
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        //初始化的二维数组
        System.out.println("原始二维数组~");
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        //二维数组转稀疏数组
        //1.先遍历二维数组，得到非0数据的个数
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++){
                if (chessArr1[i][j] != 0){
                    sum++;
                }
            }
        }
        System.out.println("sum="+sum);
        //2.创建对应的稀疏数组
        int[][] sparseArr = new int[sum+1][3];
        //给稀疏数组赋值
        sparseArr[0][0]=11;
        sparseArr[0][1]=11;
        sparseArr[0][2]=sum;

        //遍历二维数组，将非0的值存入到稀疏数组中
        int k = 0;//用于记录第几个非0数据
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++){
                if (chessArr1[i][j] != 0){
                    k++;
                    sparseArr[k][0]=i;
                    sparseArr[k][1]=j;
                    sparseArr[k][2]=chessArr1[i][j];
                }
            }
        }
        //输出稀疏数组
        System.out.println("输出稀疏数组~");
        for (int[] row : sparseArr) {
            for (int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        System.out.println("存入稀疏数组~");
        FileOutputStream fos = new FileOutputStream(new File("map.data"));
        OutputStreamWriter out = new OutputStreamWriter(fos, "UTF-8");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
            if (i == sparseArr.length - 1) {
                out.append(sparseArr[i][0] + "," + sparseArr[i][1] + "," + sparseArr[i][2]);
            } else {
                out.append(sparseArr[i][0] + "," + sparseArr[i][1] + "," + sparseArr[i][2] + ",");
            }
        }
        System.out.println("写入文件中...");
        out.close();
        fos.close();

        System.out.println("读入稀疏数组~");
        FileInputStream fis = new FileInputStream(new File("map.data"));
        InputStreamReader in = new InputStreamReader(fis, "UTF-8");
        StringBuffer sb = new StringBuffer();
        while (in.ready()){
            sb.append(((char) in.read()));// 转成char加到StringBuffer对象中
        }
        System.out.println(sb.toString());
        in.close();// 关闭读取流
        fis.close();// 关闭输入流,释放系统资源
        String[] str = sb.toString().split(",");
        int[][] sparseArr2 = new int[str.length / 3][3];
        // 给稀疏数组赋值
        int p = 0;
        for (String s : str) {
            sparseArr2[(p - (p % 3)) / 3][p % 3] = Integer.parseInt(s);
            p++;
        }

        //将稀疏数组转换成二维数组
        int[][] chessArr2 = new int[sparseArr2[0][0]][sparseArr2[0][1]];
        //从稀疏数组的第二行开始遍历
        for (int i = 1; i < sparseArr2.length; i++) {
            chessArr2[sparseArr2[i][0]][sparseArr2[i][1]]=sparseArr2[i][2];
        }
        System.out.println("二维数组~");
        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }
}
