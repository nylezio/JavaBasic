package com.codejerry.牛客.niuke2;

import java.util.Arrays;



/**
 * @author: codeJerry
 * @description:
 * niuniu的分配
 * 贪心
 * @date: 2020/08/01 21:33
 */
public class Fenpei {

    public int solve (int n, int x, int[] a) {
        if (n == 0) {
            return 0;
        }
        // write code here
        Arrays.sort(a);
        long cur = a[n - 1];
        if (cur < x) {
            return 0;
        }
        int count = 1;
        double average;
        for (int i = n - 2; i >= 0; i--) {
            cur += a[i];
            count++;
            average = (double) cur / (double) count;
            System.out.println(average);
            if (average < x) {
                return --count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Fenpei fenpei = new Fenpei();
        System.out.println(fenpei.solve(3, 7, new int[]{9, 9, 4}));
    }
}
