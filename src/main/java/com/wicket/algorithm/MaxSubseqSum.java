package com.wicket.algorithm;

import java.util.Arrays;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname MaxSubseqSum
 * @description 最大子列和问题
 * @date 2021/1/6 9:46
 */
public class MaxSubseqSum {
    /*
    三次循环
     */
    public static int triple(int[] A, int N) {
        /*
        ThisSum当前正在统计的子列的和，MaxSum保存最大子序列和
         */
        int ThisSum, MaxSum = 0;
        int i, j, k;
        //k所在循环计算每个子序列的和
        for (i = 0; i < N; i++) {
            for (j = i; j < N; j++) {
                ThisSum = 0;
                for (k = i; k <= j; k++) {
                    ThisSum += A[k];
                }
                if (ThisSum > MaxSum) {
                    MaxSum = ThisSum;
                }
            }
        }
        return MaxSum;
    }

    /*
    两次循环
     */
    public static int twice(int[] A, int N) {
        /*
        ThisSum当前正在统计的子列的和，MaxSum保存最大子序列和
         */
        int ThisSum, MaxSum = 0;
        int i, j;
        //k所在循环计算每个子序列的和
        for (i = 0; i < N; i++) {
            ThisSum = 0;
            for (j = i; j < N; j++) {
                ThisSum += A[j];
                if (ThisSum > MaxSum) {
                    MaxSum = ThisSum;
                }
            }
        }
        return MaxSum;
    }

    /*
    在线处理：遍历数列的时候，顺便累加，每次累加的和若小于0，那么我们可以认为最大子列和为负数时，一定不会让后面的部分增大了，所以就可以把它丢弃，重置当前的sum为0
     */
    public static int onLine(int[] A, int N) {
        /*
        ThisSum当前正在统计的子列的和，MaxSum保存最大子序列和
         */
        int ThisSum = 0, MaxSum = 0;
        int i;
        //k所在循环计算每个子序列的和
        for (i = 0; i < N; i++) {
            ThisSum += A[i];
            if (ThisSum < 0) {
                ThisSum = 0;
            }
            if (ThisSum > MaxSum) {
                MaxSum = ThisSum;
            }
        }
        return MaxSum;
    }

    private static int testFunction(int[] testArr, int length, int type) {
        int result = 0;
        switch (type) {
            case 1:
                result = triple(testArr, length);
                break;
            case 2:
                result = twice(testArr, length);
                break;
            case 3:
                result = onLine(testArr, length);
                break;
        }
        return result;
    }


    public static void main(String[] args) {
        /*分别测试数组元素在100，1000,10000时的表现*/
        MaxSubseqSum maxSubseqSum = new MaxSubseqSum();
        int arrayLength = 10000;
        System.out.println("数组长度：" + arrayLength);
        int[] testArr = MakeArrays.makeArray(arrayLength);
        System.out.println(Arrays.toString(testArr));
        long startTime = System.nanoTime();
        int a = testFunction(testArr,arrayLength,3);
        long duration = System.nanoTime();
        System.out.println(a);
        System.out.println("在线处理 spend time:"+ (duration-startTime)/(1000f*1000f)+"ms");

        int b = testFunction(testArr,arrayLength,2);
        long duration1 = System.nanoTime();
        System.out.println(b);
        System.out.println("2次遍历 spend time:"+ (duration1-duration)/(1000f*1000f)+"ms");

        int c = testFunction(testArr,arrayLength,1);
        long duration2 = System.nanoTime();
        System.out.println(c);
        System.out.println("3次遍历 spend time:"+ (duration2-duration1)/(1000f*1000f)+"ms");

    }
}
