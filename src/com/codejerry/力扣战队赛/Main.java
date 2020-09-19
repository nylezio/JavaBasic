package com.codejerry.力扣战队赛;

import java.util.Arrays;

/**
 * @author: codeJerry
 * @description:
 * @date: 2020/09/19 15:00
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,3,4};
        numsGame(nums);
    }

    static int[][] dp;
    public static int[] numsGame(int[] nums) {
        int n = nums.length;
        dp = new int[n][3000];
        int mod = (int) (Math.pow(10, 9)) + 7;
        int[] ans = new int[n];
        ans[0] = 0;
        int[] sum = new int[n];
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + nums[i];
            int low = ((int) Math.floor(((double) sum[i]) / (i + 1)) ) + i / 2;
            int high = ((int) Math.ceil(((double) sum[i]) / (i + 1))) + i / 2;
            if (i % 2 == 1) {
                low++;
                high++;
            }
            System.out.print(i);
            System.out.print(" ");
            System.out.print(low);
            System.out.print(" ");
            System.out.print(high);
            System.out.println();
            ans[i] = Math.min(Math.abs(low - nums[i]) + find(nums, i, low + 1000),
                                Math.abs(high - nums[i]) + find(nums, i, high + 1000));
        }
        System.out.println(Arrays.toString(ans));
        return ans;
    }

    private static int find(int[] nums, int i, int k) {
        if (dp[i][k] != 0) {
            return dp[i][k];
        }
        if (i == 0) {
            dp[i][k] = Math.abs(k - 1000 - nums[0]);
            return dp[i][k];
        }
        dp[i][k] = find(nums, i - 1, k - 1);
        return dp[i][k];
    }
}
