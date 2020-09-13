package com.codejerry.美团2;

import java.util.Scanner;

/**
 * @author: codeJerry
 * @description:（100）
 8 2 5
 5 5 5 4 5 5 5 5
 * @date: 2020/09/13 10:08
 */

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(count(n, m, k, nums));
    }

    private static int count(int n, int m, int k, int[] nums) {
        int ans = 0;
        if (n < m) {
            return 0;
        }
        int i = -1;
        int j = 0;
        while (j < n) {
            while (j < n && (j - i) < m && nums[j] >= k) {
                j++;
            }

            if (j == n) {
                break;
            }
            if (j - i == m && nums[j] >= k) {
                ans++;
                i++;
            } else if (nums[j] < k) {
                i = j;
                j++;
            }


        }
        return ans;
    }
}
