package com.codejerry.触宝;

import java.util.Scanner;

/**
 * @author: codeJerry
 * @description:
 123
 * @date: 2020/08/25 20:07
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        while (n > 0) {
            n = n & (n - 1);
            count++;
        }
        System.out.println(count);
    }
}
