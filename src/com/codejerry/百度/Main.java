package com.codejerry.百度;

import java.util.Scanner;

/**
 * @author: codeJerry
 * @description:
 * @date: 2020/09/03 19:41
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = 0;
        int b = 0;
        for (int i = 0; i < n; i++) {
            if (sc.nextInt() == 0) {
                a++;
            } else {
                b++;
            }
        }
        count(a, b);
    }

    private static void count(int a, int b) {
        if (b >= 9 && a > 0) {
            b /= 9;
            while (b > 0) {
                System.out.print("555555555");
                b--;
            }
            while (a > 0) {
                System.out.print(0);
                a--;
            }
        } else if (a > 0) {
            System.out.println(0);
        } else {
            System.out.println(-1);
        }

    }

}
