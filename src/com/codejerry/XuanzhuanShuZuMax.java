package com.codejerry;

/**
 * @author: codeJerry
 * @description:
 * @date: 2020/08/05 21:28
 */
public class XuanzhuanShuZuMax {
    public static void main(String[] args) {
//        int[] nums = new int[]{5,1,2,3,4};
//        int[] nums = new int[]{1,2,3,4,5};
        int[] nums = new int[]{3,4,5,1,2};
        int i = 0;
        int j = nums.length - 1;
        int target = nums[0];
        while (i <= j) {
            int mid = i + ((j - i) >> 1);
            if (nums[mid] == target) {
                i = mid + 1;
            } else if (nums[mid] > target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        System.out.println(j);
    }
}
