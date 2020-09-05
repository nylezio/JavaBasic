package com.codejerry.腾讯;

import java.util.Scanner;

/**
 * @author: codeJerry
 * @description:
5 3
1 2 3 4 5
 * @date: 2020/08/23 19:56
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (i != k - 1) {
                sb.append(num);
                sb.append(" ");

            }
        }
        System.out.print(sb);
    }
}
