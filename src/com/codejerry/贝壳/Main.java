package com.codejerry.贝壳;

import java.util.Scanner;

/**
 2
 6 5 8 9
 1 20 1 0
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] need = new int[2 * n];
        int[] profile = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            need[i] = sc.nextInt();
        }
        for (int i = 0; i < 2 * n; i++) {
            profile[i] = sc.nextInt();
        }
        int changeL = 0;
        int needL = 1;
        for(int i = 0; i < n; i++) {
            changeL = changeL - need[i] + profile[i];
            needL = Math.max(needL - profile[i] + need[i], need[i]);
        }
        int profileL = needL + changeL;

        int changeR = 0;
        int needR = 1;
        for (int i = 2 * n - 1; i >= n; i--) {
            changeR = changeR - need[i] + profile[i];
            needR = Math.max(needR - profile[i] + need[i], need[i]);
        }
        int profileR = needR + changeR;
        System.out.println(Math.min(needL + (Math.max(needR - profileL, 0)),
                needR + Math.max((needL - profileR), 0)));
    }
}
