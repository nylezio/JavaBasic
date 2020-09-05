package com.codejerry.拼多多2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: codeJerry
 * @description: 4 20
 * 4 -1
 * 2 -1
 * 3 1
 * 6 6
 * @date: 2020/09/01 19:01
 */
public class Main3 {
    static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] nums = new int[n][2];
        int sumM = m;
        for (int i = 0; i < n; i++) {
            nums[i][0] = sc.nextInt();
            nums[i][1] = sc.nextInt();
            if (nums[i][0] < 0) {
                sumM += nums[i][0];
            }
        }
        Arrays.sort(nums, (a, b) -> a[0] - b[0]);
        int[] dp = new int[sumM + 1];
        int curM = m;
        for (int i = 0; i < n; i++) {
//            curM =
            for (int j = m; j >= 0; j--) {
                if (j >= nums[i][0]) {
                    dp[j] = Math.max(dp[j], dp[j - nums[i][0]] + nums[i][1]);
                }
            }
        }
        System.out.println(dp[m]);
    }

    private static void dfs(int[][] nums, int index, int cur, int m) {
        if (index == nums.length) {
            return;
        }
        ans = Math.max(ans, cur);

        dfs(nums, index + 1, cur, m);
        if (m >= nums[index][0]) {
            dfs(nums, index + 1, cur + nums[index][1], m - nums[index][0]);
        }
    }
}
