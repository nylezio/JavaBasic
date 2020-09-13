package com.codejerry;

import jdk.internal.org.objectweb.asm.tree.MultiANewArrayInsnNode;

import java.util.Arrays;

public class Int {
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{2, 1, -2, 3}, 5));
    }


    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                // 判断最小值
                int min = nums[i] + nums[start] + nums[start + 1];
                if (target < min) {
                    if (Math.abs(min - target) < Math.abs(ans - target))
                        ans = min;
                    break;
                }
                //判断最大值
                int max = nums[i] + nums[end] + nums[end - 1];
                if (target > max) {
                    if (Math.abs(max - target) < Math.abs(ans - target))
                        ans = max;
                    break;
                }

                int sum = nums[i] + nums[start] + nums[end];
                if (Math.abs(sum - target) < Math.abs(ans - target)) {
                    ans = sum;
                }
                if (sum == target) {
                    return target;
                } else if (sum < target) {
                    start++;
                    while (start < end && nums[start] == nums[start - 1]) {
                        start++;
                    }
                } else {
                    end--;
                    while (start < end && nums[end] == nums[end + 1]) {
                        end--;
                    }
                }
            }
            while (i < nums.length - 2 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return ans;
    }


}



