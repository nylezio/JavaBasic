package com.codejerry.腾讯;

import java.util.Scanner;

/**
 * @author: codeJerry
 * @description: 5 3
 * 1 2 3 4 5
 * @date: 2020/08/23 19:56
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(dfs(nums, 0, n - 1));
    }

    private static int dfs(int[] nums, int l, int r) {
        int min = Integer.MAX_VALUE;
        for (int i = l; i <= r; i++) {
            min = Math.min(min, nums[i]);
        }
        for (int i = l; i <= r; i++) {
            nums[i] -= min;
        }
        int p = l;
        int ans = min;
        for (int i = l; i <= r; i++) {
            if (nums[i] != 0) {
                p = i;
                break;
            }
        }
        for (int i = p; i <= r; i++) {
            if (nums[i] == 0) {
                ans += dfs(nums, p, i - 1);
                p = i + 1;
            }
        }
        if (p <= r) {
            ans += dfs(nums, p, r);
        }
        return Math.min(ans, r - l + 1);
    }

}
