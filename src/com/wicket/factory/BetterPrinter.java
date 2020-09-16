package com.wicket.factory;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname BetterPrinter
 * @description TODO
 * @date 2020/8/26 10:24
 */
public class BetterPrinter implements Output {

    private String[] printData = new String[3];

    private int dataNum = 0;

    @Override
    public void out() {
        while(dataNum > 0){
            System.out.println("高速打印机正在打印："+ printData[0]);
            System.arraycopy(printData , 1 ,printData,0 , --dataNum);
        }
    }

    @Override
    public void getData(String msg) {
        if(dataNum >= 3){
            System.out.println("队列已满，添加失败");
        }else{
            printData[dataNum++] = msg;
        }
    }
}
