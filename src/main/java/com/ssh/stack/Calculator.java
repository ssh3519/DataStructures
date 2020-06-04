package com.ssh.stack;

/**
 * @author: ssh
 * @email: 18367183519@163.com
 * @Date: 2020/6/3 0003 22:50
 */
public class Calculator {
    public static void main(String[] args) {
        String expression = "300+2*6-2";
        //创建2个栈。数栈，符号栈
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        int index = 0;//用于扫描
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';//将每次扫描的char保存到ch中
        String keepNum = "";//用于拼接多位数
        while (true) {
            //得到每个字符
            ch = expression.substring(index, index + 1).charAt(0);
            //判断ch是什么
            if (operStack.isOper(ch)) {
                //如果是运算符，判断当前符号栈是否为空
                if (!operStack.isEmpty()) {
                    //比较当前运算符的优先级和符号栈顶运算符的优先级（当前运算符的优先级<=符号栈顶运算符的优先级）
                    //从数栈中pop出2个数，从符号栈中pop出一个运算符，进行运算，然后得到的数入数栈，ch入符号栈
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        numStack.push(res);
                        operStack.push(ch);
                    } else {
                        operStack.push(ch);
                    }

                } else {
                    //为空直接入栈
                    operStack.push(ch);
                }
            } else {
                //如果是数，直接入栈
                //考虑多位数
                keepNum+=ch;

                //如果ch已经是最后一位，直接入栈
                if (index == expression.length()-1){
                    numStack.push(Integer.parseInt(keepNum));
                }else{
                    //判断下一个字符是否是数字还是运算符
                    if (operStack.isOper(expression.substring(index+1,index+2).charAt(0))){
                        //如果后一位是运算符，则入栈keepNum
                        numStack.push(Integer.parseInt(keepNum));
                        //清空keepNum
                        keepNum = "";
                    }
                }
            }
            index = index + 1;
            //expression扫描结束
            if (index >= expression.length()) {
                break;
            }
        }

        //扫描结束，就顺序从数栈和符号栈中pop出数和符号，并运算
        while (true){
            //如果符号栈为空，则数栈中只有一个数，为结果
            if (operStack.isEmpty()){
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1, num2, oper);
            numStack.push(res);
        }
        res = numStack.pop();
        System.out.printf("%s = %d",expression,res);
    }
}

class ArrayStack2 {
    private int maxSize;//栈大小
    private int[] stack;//数组模拟栈
    private int top = -1;//top表示栈顶，初始化-1

    //构造器
    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    public int[] getStack() {
        return stack;
    }

    public int getTop() {
        return top;
    }

    //栈是否满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //栈是否空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈
    public void push(int val) {
        //栈满
        if (isFull()) {
            System.out.println("栈已满");
            return;
        }
        stack[++top] = val;
    }

    //出栈
    public int pop() {
        //栈空
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        int val = stack[top];
        top--;
        return val;
    }

    //栈顶元素
    public int peek() {
        return stack[top];
    }

    //遍历栈，从栈顶开始
    public void list() {
        //栈空
        if (isEmpty()) {
            System.out.println("栈空");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }

    //返回运算符的优先级，数字越大，优先级越大
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    //判断是不是一个运算符
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    //计算方法
    public int cal(int num1, int num2, int oper) {
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
                break;
        }
        return res;
    }
}

