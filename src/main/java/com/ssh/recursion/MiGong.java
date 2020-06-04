package com.ssh.recursion;

/**
 * 递归-迷宫问题
 *
 * @author: ssh
 * @email: 18367183519@163.com
 * @Date: 2020/6/4 0004 16:38
 */
public class MiGong {
    public static void main(String[] args) {
        //创建一个二维数组，模拟迷宫
        //地图
        int[][] map = new int[8][7];

        //上下全为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //左右全为1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }

        //设置挡板
        map[3][1] = 1;
        map[3][2] = 1;

//        map[1][2] = 1;
//        map[2][2] = 1;

        //遍历
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }

        //递归找路
        setWay(map,1,1);
        System.out.println("新地图--------------------------");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }
    }

    //使用递归回溯来个小球找路

    /**
     *  终点map[6][5]
     *  map[i][j] 0：表示该点没走过  1：表示墙  2：表示通路可以走  3：表示该点已经走过，但走不通
     *  策略：下->右->上->左，如果该点走不通，再回溯
     * @param map 地图
     * @param i 起始位置
     * @param j 起始位置
     * @return 找到true
     */
    public static boolean setWay(int[][] map,int i,int j){
        if (map[6][5] == 2){//通路已找到
            return true;
        }else {
            if (map[i][j] == 0){//这个点没走过
                map[i][j] = 2;//假设这个点可以走通
                //按照策略走，下->右->上->左
                if (setWay(map,i+1,j)){
                    return true;
                }else if (setWay(map,i,j+1)){
                    return true;
                }else if (setWay(map,i-1,j)){
                    return true;
                }else if (setWay(map,i,j-1)){
                    return true;
                }else{
                    //说明该点走不通
                    map[i][j] = 3;
                    return false;
                }
            }else{
                //1 2 3
                return false;
            }
        }
    }
}
