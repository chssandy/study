package com.wicket.algorithm;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname SortedArrayDuplicates
 * @description 删除排序数组中的重复项，双指针算法
 * @date 2021/6/8 11:57
 */
public class SortedArrayDuplicates {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0,1,2,2,3,3,4}));
    }

    private static int removeDuplicates(int[] nums) {
        if(nums == null || nums.length ==0){
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if(nums[i] != nums[j]){
                i++;
                nums[i]=nums[j];
            }
        }
        return i+1;
    }


}
