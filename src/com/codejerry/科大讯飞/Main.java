package com.codejerry.科大讯飞;

import java.util.Scanner;

/**
 * @author: codeJerry
 * @description:
 * 5 2 2 3 5
 * 55
 * @date: 2020/07/31 13:08
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] count = new int[]{1,5,10,50,100};
        int[] nums = new int[5];
        for (int i = 0; i < 5; i++) {
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(method(nums, count, k));

    }

    private static int method(int[] count, int[] nums, int k) {
        int ans = 0;
        for (int i = nums.length - 1; i >= 0 ; i--) {
            int tmp = k / nums[i];
            int q = Math.min(tmp, count[i]);
            ans += q;
            k -= nums[i] * q;
        }
        if (k > 0) {
            return -1;
        }
        return ans;
    }

}