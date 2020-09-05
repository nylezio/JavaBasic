package com.codejerry.背包;

import java.util.Scanner;

/**
 * @author: codeJerry
 * @description:
 * 多重背包问题
10 2 1 1
6 3 2 50
8 2 1 10
 * 10g面粉 2种馅料 不用馅料1g面粉 收益1
 * 6g馅料 3g馅料做一个 2g面粉 收益50
 * 8g馅料 2g馅料做一个 1g面粉 收益10
 * @date: 2020/07/17 18:51
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        m代表总容量
        int m = sc.nextInt();
//        n代表可选的种类
        int n = sc.nextInt();
//        物品的体积
        int v0 = sc.nextInt();
//        物品的收益
        int w0 = sc.nextInt();
        int[] f = new int[m + 1];
        for (int j = m; j >= 0; j--) {
            for (int k = 0; k * v0 <= j; k++) {
                f[j] = Math.max(f[j], f[j - k * v0] + k * w0);
            }
        }
        for (int i = 0; i < n; i++) {
            int v, w, s;
            int a, b;
            a = sc.nextInt();
            b = sc.nextInt();
            s = a / b;
            v = sc.nextInt();
            w = sc.nextInt();
            for (int j = m; j >= 0; j--) {
                for (int k = 0; k <= s && k * v <= j; k++) {
                    f[j] = Math.max(f[j], f[j - k * v] + k * w);
                }
            }
        }
        System.out.println(f[m]);
    }
}