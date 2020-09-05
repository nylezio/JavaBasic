package com.codejerry.触宝;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: codeJerry
 * @description: 123
 * @date: 2020/08/25 20:07
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] times = sc.nextLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(times[i]);
        }
        Arrays.sort(nums);
        int ans = count(nums);
        int m = sc.nextInt();
        if (ans <= m) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private static int count(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = nums[0] + nums[1] + nums[2];
        for (int i = 3; i < n; i++) {
            dp[i] = Math.min(dp[i - 1] + nums[0] + nums[i], dp[i - 2] + nums[0] + nums[i] + 2 * nums[1]);
        }
        return dp[n - 1];
    }
}
