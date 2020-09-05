package com.codejerry.网易;

import java.util.Scanner;

/**
 * @author: codeJerry
 * @description:
 * 三进制枚举法
 * @date: 2020/08/08 15:28
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            long max = Integer.MIN_VALUE;
            int n = sc.nextInt();
            int[] nums = new int[n];
            long sum = 0;
            long temp = 1;
            temp = (long) Math.pow(3, n);
            for (int j = 0; j < n; j++) {
                nums[j] = sc.nextInt();
                sum += nums[j];
            }
            for (int j = 0; j < temp; j++) {
                long valA = 0;
                long valB = 0;
                int k = 0;
                int p = j;
                while (p > 0) {
                    if (p % 3 == 1) {
                        valA += nums[k];
                    }
                    if (p % 3 == 2) {
                        valB += nums[k];
                    }
                    k++;
                    p /= 3;
                }
                if (valA == valB) {
                    max = Math.max(max, valA + valB);
                }

            }
            System.out.println(sum - max);
        }
    }


}
