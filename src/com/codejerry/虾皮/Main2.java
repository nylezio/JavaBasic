package com.codejerry.虾皮;

/**
 * @author: codeJerry
 * @description:
 * @date: 2020/08/12 15:05
 */
public class Main2 {
    public static int missingNumber (int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums.length) {
                continue;
            }
            int t = Math.abs(nums[i]);
            nums[t] = - nums[t];
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i;
            }
        }
        return  nums.length;
    }

    public static void main(String[] args) {
//        int[] nums = {9,6,2,4,3,5,7,0,1};
        int[] nums = {3,0,1};
        System.out.println(missingNumber(nums));
    }
}
