package com.wicket.designPattern.command;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname CommandTest
 * @description TODO
 * @date 2020/8/26 13:38
 */
public class LambdaTest {
    public static void main(String[] args) {
        ProcessArray pa = new ProcessArray();
        int[] target = {3,-4,6,4};
        pa.each(target, array ->{
            for(int tmp : target){
                System.out.println("迭代输出目标数组的元素："+ tmp);
            }
        });
        System.out.println("----------");
        pa.each(target, array-> {
            int sum = 0;
            for(int tmp : target){
                sum += tmp;
            }
            System.out.println("数组元素的总和是：" + sum);
        });
    }
}
