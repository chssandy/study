package com.wicket.algorithm;

import java.util.Random;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname MakeArrays
 * @description TODO
 * @date 2021/1/7 9:48
 */
public class MakeArrays {
    public static int[] makeArray(int length) {
        int[] array = new int[length];
        Random random = new Random(1);
        for (int i = 0; i < length; i++) {
            int x = random.nextInt(200)-100;
            array[i] = x;
        }
        return array;
    }
}
