package com.codejerry.远景;

import java.util.Scanner;

//3
//5
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        count(n);
    }

    private static void count(int n) {
        int ans = 0;
        while (n > 0) {
            n /= 5;
            ans += n;
        }
        System.out.println(ans);
    }
}
