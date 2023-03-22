package com.wicket.algorithm;

import java.util.HashSet;

/**
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname Test42
 * @description TODO
 * @date 2022/08/22 9:54
 */
public class Code_42_SubsquenceMaxModM {
    /*
     * 给定一个非负数组arr，和一个正数m。返回arr的所有子序列中累加和%m的最大值。
     */
    public static int max1(int[] arr,int m){
        HashSet<Integer> set = new HashSet<>();
        process(arr,0,0,set);
        int max = 0;
        for(Integer sum : set){
            max = Math.max(max,sum % m);
        }
        System.out.println(max);
        return max;
    }

    public static void process(int[] arr,int index ,int sum,HashSet<Integer> set){
        if(index == arr.length){
            set.add(sum);  //遍历至数组结尾，将这一轮的和sum，添加到set中
        }else{
            process(arr, index + 1, sum, set);  //不把当前的数累加到sum中
            process(arr, index + 1, sum + arr[index], set);  //把当前index位置的数，累加到sum中
        }
    }

    public static void main(String[] args) {
        int[] arr = {5,1,2};
        max1(arr,5);
    }
}
