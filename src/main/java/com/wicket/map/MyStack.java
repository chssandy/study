package com.wicket.map;

import java.util.Stack;

/**
  *@copyright WICKET.COM
  *@classname MyStack
  *@description LIFO（Last in  first Out） 后进先出
  *@author   CHS
  *@date 2021/4/27 17:15
  *@version 1.0
  *@param
  */
public class MyStack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();  //创建一个字符串类型的堆栈
        stack.push("123");
        stack.push("456");
        stack.push("123");     //入栈

        int pos = stack.search("456");    //查找字符串123在栈中的位置
        System.out.println("The position  of abc:" + pos);
        boolean empty = stack.empty();    //判断堆栈是否为空
        String obj = stack.peek();        //返回栈顶元素，不出栈
        System.out.println(stack.toString());
        String top = stack.pop();         //返回栈顶元素，出栈
        System.out.println("The top of stack:" +  top);
        System.out.println(stack.toString());
    }
}
