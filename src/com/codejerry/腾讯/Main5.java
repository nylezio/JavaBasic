package com.codejerry.腾讯;

import java.util.Scanner;

/**
 * @author: codeJerry
 * @description: ababa
ababa
4
1 4
1 5
1 2
1 3
 * @date: 2020/08/23 19:56
 */
public class Main5 {
    static int[][] dp;
    static boolean[][] isH;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = s.length();
        dp = new int[n][n];
        isH = new boolean[n][n];
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            System.out.println(count(s, l - 1, r - 1));
        }

    }

    private static int count(String s, int l, int r) {
        if (dp[l][r] != 0) {
            return dp[l][r];
        }

        if (l == r) {
            dp[l][r] = 1;
            return dp[l][r];
        }

        int ans = r - l + 1;
        for (int i = r; i > l; i--) {
            if (check(s, l, i)) {
                if (i == r) {
                    ans = 1;
                    break;
                } else {
                    ans = Math.min(ans, 1 + count(s,i + 1, r));
                }
            }
        }
        dp[l][r] = ans;
        return ans;
    }

    private static boolean check(String s, int l, int r) {
        if (isH[l][r]) {
            return true;
        }
        if (r - l <= 0) {
            isH[l][r] = true;
            return true;
        }
        if (s.charAt(l) == s.charAt(r)) {
            if (r - l <= 2 || check(s, l + 1, r - 1)) {
                isH[l][r] = true;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

}
