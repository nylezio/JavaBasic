package com.codejerry.美团;

import java.util.Scanner;

/**
 * @author: codeJerry
 * @description:
 * 6辆车 2辆派往a地 2辆派往b地，选出最佳的方案
6 2 2
4 2
3 3
5 4
5 3
1 5
8 8
输出 20
 * @date: 2020/08/15 16:53
 */
public class Main {
    static int[][] nums;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            nums[i][0] = sc.nextInt();
            nums[i][1] = sc.nextInt();
        }

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans = Math.max(ans, dp(a, b, 0, i + 1, nums.length));
            ans = Math.max(ans, dp(a - 1, b, nums[i][0], i + 1, nums.length));
            ans = Math.max(ans, dp(a, b - 1, nums[i][1], i + 1, nums.length));
        }
        System.out.println(ans);
    }


    private static int dp(int a, int b, int cur, int l, int r) {
        if (a < 0 || b < 0) {
            return 0;
        }
        if (a == 0 && b == 0) {
            return cur;
        }
        int ans = 0;
        for (int i = l; i < r; i++) {
            ans = Math.max(ans, dp(a, b, 0, i + 1, nums.length));
            ans = Math.max(ans, dp(a - 1, b, nums[i][0], i + 1, nums.length));
            ans = Math.max(ans, dp(a, b - 1, nums[i][1], i + 1, nums.length));
        }

        return cur + ans;
    }

}
