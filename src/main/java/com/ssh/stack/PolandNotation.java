package com.ssh.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * （后缀表达式）逆波兰表达式
 * @author: ssh
 * @email: 18367183519@163.com
 * @Date: 2020/6/4 0004 11:06
 */
public class PolandNotation {
    public static void main(String[] args) {
        //定义一个后缀表达式
        String suffixExpression = "3 4 + 5 * 6 -";
        List<String> list = getListString(suffixExpression);
        System.out.println(list);
        System.out.println(calculate(list));
    }

    //将后缀表达式，放入ArrayList
    public static List<String> getListString(String suffixExpression){
        String[] str = suffixExpression.split(" ");
        List<String> list = new ArrayList<>(Arrays.asList(str));
        return list;
    }

    //计算
    public static int calculate(List<String> list){
        Stack<String> stack = new Stack<>();
        for (String str : list) {
            if (str.matches("\\d+")){
                //匹配多位数，入栈
                stack.push(str);
            }else{
                //如果是运算符，pop2个数，运算后的结果push到栈中
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int res = cal(num1, num2, str.charAt(0));
                //结果入栈
                stack.push(String.valueOf(res));
            }
        }
        return Integer.parseInt(stack.pop());
    }

    //计算方法
    public static int cal(int num1, int num2, char oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;//顺序
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;//顺序
                break;
            default:
                throw new RuntimeException("运算符错误");
        }
        return res;
    }
}
