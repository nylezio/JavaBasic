package com.codejerry.兴业;

import java.util.Scanner;

/**
 * @author: codeJerry
 * @description:
 * （100）
 * @date: 2020/09/15 22:43
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(",");
        int[] nums = new int[strs.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[(nums[i] - 1) % n] += n;
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 2 * n) {
                System.out.print(i + 1);
                System.out.print(" ");
            }
        }
        
    }
}
