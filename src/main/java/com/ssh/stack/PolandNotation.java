package com.ssh.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * （后缀表达式）逆波兰表达式
 *
 * @author: ssh
 * @email: 18367183519@163.com
 * @Date: 2020/6/4 0004 11:06
 */
public class PolandNotation {
    public static void main(String[] args) {
/*        //定义一个后缀表达式
        String suffixExpression = "3 4 + 5 * 6 -";
        List<String> list = getListString(suffixExpression);
        System.out.println(list);
        System.out.println(calculate(list));*/


        String expression = "1+((2+3)*4)-5";
        List<String> list = toInfixExpression(expression);
        System.out.println("中缀表达式对应的list："+list);
        //中缀表达式对应的list => 后缀表达式对应的list
        List<String> list2 = parseSuffixExpressionList(list);
        System.out.println("后缀表达式对应的list："+list2);
        System.out.println(expression+"="+calculate(list2));
    }

    //中缀表达式对应的list => 后缀表达式对应的list
    public static List<String> parseSuffixExpressionList(List<String> list) {
        Stack<String> s1 = new Stack<>();//符号栈
        List<String> s2 = new ArrayList<>();//存储中间结果
        for (String item : list) {
            if (item.matches("\\d+")) {
                //如果是数字，加入s2
                s2.add(item);
            } else {
                if (item.equals("(")) {
                    s1.push(item);
                } else if (item.equals(")")) {
                    while (!s1.peek().equals("(")) {
                        s2.add(s1.pop());
                    }
                    s1.pop();
                } else {
                    //item优先级 <= 栈顶运算符优先级，弹出s1栈顶到s2
                    //判断栈顶的运算符
                    while (s1.size()!=0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)){
                        s2.add(s1.pop());
                    }
                    s1.push(item);
                }
            }
        }
        while (!s1.isEmpty()){
            s2.add(s1.pop());
        }
        return s2;

    }

    //中缀表达式转list
    public static List<String> toInfixExpression(String str) {
        List<String> list = new ArrayList<>();
        int i = 0;//指针，遍历中缀表达式
        String s;//多位数拼接
        char c;//遍历的字符
        while (i < str.length()) {
            if ((c = str.charAt(i)) < 48 || (c = str.charAt(i)) > 57) {
                //如果是非数字
                list.add(String.valueOf(c));
                i++;
            } else {
                //是数字
                s = "";//多位数拼接
                while (i < str.length() && (c = str.charAt(i)) >= 48 && (c = str.charAt(i)) <= 57) {
                    s += c;
                    i++;
                }
                list.add(s);
            }
        }
        return list;
    }

    //将后缀表达式，放入ArrayList
    public static List<String> getListString(String suffixExpression) {
        String[] str = suffixExpression.split(" ");
        List<String> list = new ArrayList<>(Arrays.asList(str));
        return list;
    }

    //后缀表达式计算
    public static int calculate(List<String> list) {
        Stack<String> stack = new Stack<>();
        for (String str : list) {
            if (str.matches("\\d+")) {
                //匹配多位数，入栈
                stack.push(str);
            } else {
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

//返回运算符对应的优先级
class Operation{
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    public static int getValue(String operation){
        int res = 0;
        switch (operation){
            case "+":
                res = ADD;
                break;
            case "-":
                res = SUB;
                break;
            case "*":
                res = MUL;
                break;
            case "/":
                res = DIV;
                break;
            default:
                break;
        }
        return res;
    }
}
