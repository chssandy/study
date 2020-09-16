package com.wicket.factory;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname Printer
 * @description TODO
 * @date 2020/8/26 10:40
 */
public class Printer implements Output {
    private String[] printData = new String[3];

    private int dataNum = 0;
    public void out(){
        while(dataNum > 0){
            System.out.println("打印机打印："+ printData[0]);
            System.arraycopy(printData , 1, printData ,0 , --dataNum);
        }
    }

    public void getData(String msg){
        if(dataNum >= 3){
            System.out.println("输出队列已满，添加失败");
        }else{
            printData[dataNum++] = msg;
        }
    }
}
