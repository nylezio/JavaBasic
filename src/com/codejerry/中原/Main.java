package com.codejerry.中原;

import java.util.Scanner;

/**
 * @author: codeJerry
 * @description:
 * @date: 2020/08/23 19:41
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] strs = s.split(",");
        int x = Integer.parseInt(strs[0]);
        int y = Integer.parseInt(strs[1]);

        count(x,y);
    }

    private static void count(int x, int y) {
        int ans = 0;
        while (y > x) {
            y /= 2;
            ans++;
        }
        ans += x - y;
        System.out.println(ans);
    }
}
