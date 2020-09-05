package com.codejerry.京东;

import java.util.Scanner;

/**
 * @author: codeJerry
 * @description:
 * @date: 2020/08/27 19:00
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        arr[0]  = 0;
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        for (int i = 1; i <= n; i++) {
            arr[i] = Math.min(Math.min(arr[p1] * 10 + 2, arr[p2] * 10 + 3), arr[p3] * 10 + 5);
            if (arr[i] == arr[p1] * 10 + 2) {
                p1++;
            }
            if (arr[i] == arr[p2] * 10 + 3) {
                p2++;
            }
            if (arr[i] == arr[p3] * 10 + 5) {
                p3++;
            }

        }
        System.out.println(arr[n]);
    }
}
