package PolishNotation;

import java.util.Stack;

/**
 * 波兰表达式
 */
public class Solution1 {

    public static void main(String[] args) {
        String[] tokens = new String[]{"2","1","+","3","*"};
        System.out.println(evalRPN(tokens));

    }

    public static int evalRPN(String[] tokens){
        int returnValue = 0;
        String operators = "+-*/";
        Stack<String> stack = new Stack<>();
        for(String t:tokens){
            if(!operators.contains(t)){
                //非操作符入栈
                stack.push(t);
            }else{
                //操作符出栈计算在入栈
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                switch (t){
                    case "+":
                        stack.push(String.valueOf((a+b)));
                        break;
                    case "-":
                        stack.push(String.valueOf((a-b)));
                        break;
                    case "*":
                        stack.push(String.valueOf((a*b)));
                        break;
                    case "/":
                        stack.push(String.valueOf((a+b)));
                        break;
                }
            }
        }
        returnValue = Integer.valueOf(stack.pop());
        return returnValue;
    }
}
