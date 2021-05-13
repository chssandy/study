package com.wicket.thread;

import java.util.Arrays;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname Shared
 * @description TODO
 * @date 2021/5/7 9:07
 */
public class Shared3 {
    static final int SIZE =20;  //定义数组大小
    static volatile int nums[] = new int[SIZE]; //对共享数据使用volatile
    static volatile int first = 0;
    static volatile int last = 0;
    static volatile boolean ready = false;   //访问状态初始化
    public synchronized  void sorting(){                   //方法sorting
        try {
            if(!ready) {
                for (int i = 0; i < nums.length; i++) {     //数组初始化
                    nums[i] = (int) (Math.random() * 10000);
                }
                Arrays.sort(nums);                   //排序
                for (int num : nums) {
                    System.out.print(num + " ");   //打印排序后的结果
                }
                System.out.println();
                first = nums[0];                    //最小数据
                last = nums[SIZE - 1];              //最大数据
                ready = true;                       //准备完毕
                wait();

            }else{
                ready = false;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public synchronized void printing(){                 //方法printing
        if(ready){                      //如果可访问
            notifyAll();
            System.out.println("the first number: " + first);
            System.out.println("the last number: " + last);
        }
    }
}
