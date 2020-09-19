package com.codejerry.依图2;

import java.util.Scanner;

/**
 * @author: codeJerry
 * @description: (100)
 * @date: 2020/09/17 19:03
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 1;
        double speed = 0;
        int t0 = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        for (int i = 1; i < n; i++) {
            int t1 = sc.nextInt();
            int d = sc.nextInt();
            int e = sc.nextInt();
            int f = sc.nextInt();
            double newSpeed = count(t0, a, b, c, t1, d, e, f);
            if (newSpeed > speed) {
                speed = newSpeed;
                ans = i;
            }
            t0 = t1;
            a = d;
            b = e;
            c = f;
        }
        System.out.println(ans);
    }

    private static double count(int t0, int a, int b, int c, int t1, int d, int e, int f) {
        double dis = Math.pow(Math.pow((a - d), 2) + Math.pow((b - e), 2) + Math.pow((c - f), 2), 0.5);
        return dis / (t1 - t0);
    }
}
