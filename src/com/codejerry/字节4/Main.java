package com.codejerry.字节4;



public class Main {
    /**
     * 走楼梯只能走步或者两步，同时不能连续走两次两步
     */
    public static long count(int n) {

        long[][] dp = new long[n < 3 ? 3 : n + 1][2];
        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[1][0] = 1;
        dp[1][1] = 0;
        dp[2][0] = 1;
        dp[2][1] = 1;
        for (int i = 3; i < n + 1; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
            dp[i][1] = dp[i - 2][0];
        }
        return dp[n][0] + dp[n][1];
    }

    public static void main(String[] args) {
        System.out.println(count(5));
    }
}
