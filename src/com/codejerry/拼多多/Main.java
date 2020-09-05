package com.codejerry.拼多多;

import java.util.Scanner;

/**
 * @author: codeJerry
 * @description:
 * K 距离 N 次数
 * N次的点数
10 2
6 3
 * @date: 2020/08/02 19:02
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
//        int[] point = new int[n];
        int count = 0;
        boolean flag = false;
        if (k == 0) {
            System.out.println("paradox");
            flag = true;
        }
        for (int i = 0; i < n; i++) {
            if (flag == true) {
                break;
            }
            int c = sc.nextInt();
            if (k - c == 0) {
                k = 0;
                if (i != n - 1) {
                    System.out.println("paradox");
                    flag = true;
                    break;
                }
            } else if (k - c > 0) {
                k -= c;
            } else {
                k -= c;
                k = -k;
                count++;
            }
        }
        if (flag == false) {
            System.out.println(k + " " + count);
        }
    }

}
