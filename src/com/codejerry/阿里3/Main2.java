package com.codejerry.阿里3;

import java.util.Scanner;

/**
 * @author: codeJerry
 * @description:
 *
 * @date: 2020/08/14 19:14
 */
public class Main2 {
    static long ans;
    static int mod = 1_000_000_007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            count(s);
            System.out.println(ans % mod);
        }
    }

    private static void count(String s) {
        ans = 0L;
        int tmp = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            tmp += s.charAt(i) - '0';

        }
        dfs(tmp, len, 0);
    }

    private static void dfs(int tmp, int len, int cur) {
        if (cur == len) {
            if (tmp == 0) {
                ans++;
            }
            return;
        }
        for (int i = 0; i <= 9; i++) {
            if (tmp >= i) {
                dfs(tmp - i, len, cur + 1);
            }
        }
    }
}
