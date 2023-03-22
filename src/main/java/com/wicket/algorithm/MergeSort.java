package com.wicket.algorithm;

import java.util.Arrays;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname MaxSubseqSum
 * @description 归并排序算法
 * @date 2021/1/6 9:46
 */
public class MergeSort {

    public static void sort(int[] array){
        int length = array.length;
        int[] tmpArray = new int[ length ];
        sort(array, tmpArray, 0, length-1);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] array, int[] tmpArray, int left, int right){
        if(left < right){
            int center = (left + right)/2;    //取中间值
            sort(array, tmpArray, left, center);    //递归分解
            sort(array, tmpArray, center+1, right);    //递归分解
            merge(array, tmpArray, left, center+1, right);    //合并排序
        }
    }

    private static void merge(int[] array, int[] tmpArray, int leftStart, int rightStart, int rightEnd) {
        int leftEnd = rightStart - 1;    //左侧数组截止下标
        int tmpPos = leftStart;    //数组坐标
        int total = rightEnd - leftStart + 1;    //需要合并的数组元素数量

        while(leftStart <= leftEnd && rightStart <= rightEnd){
            if(array[ leftStart ] <= array[ rightStart ]){
                //如果左侧数组元素小于或等于右侧数组元素，将左侧数组元素的值存入临时数组，并移动左侧数组下标
                tmpArray[ tmpPos++ ] = array[ leftStart++ ];
            }else{
                //如果左侧数组元素大于右侧数组元素，将右侧数组元素的值存入临时数组，并移动右侧数组下标
                tmpArray[ tmpPos++ ] = array[ rightStart++ ];
            }
        }

        //如果左侧数组元素没有全部存入临时数组，将剩余元素循环写入临时数组
        while(leftStart <= leftEnd){
            tmpArray[ tmpPos++ ] = array[ leftStart++ ];
        }

        //如果右侧数组元素没有全部存入临时数组，将剩余元素循环写入临时数组
        while(rightStart <= rightEnd){
            tmpArray[ tmpPos++ ] = array[ rightStart++ ];
        }

        //将临时数组中排序好的元素写入原数组
        for(int i = 0; i < total; i++, rightEnd-- ){
            array[ rightEnd ] = tmpArray[ rightEnd ];
        }
    }

    public static void main(String[] args) {
        /*分别测试数组元素在100，1000,10000时的表现*/
        int arrayLength = 100;
        System.out.println("数组长度：" + arrayLength);
        int[] testArr = MakeArrays.makeArray(arrayLength);
        System.out.println(Arrays.toString(testArr));
        sort(testArr);
    }
}