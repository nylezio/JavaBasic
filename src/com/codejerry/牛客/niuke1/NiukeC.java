package com.codejerry.牛客.niuke1;

import java.util.Arrays;

/**
 * @author: codeJerry
 * @description:
 * @date: 2020/07/31 12:30
 */
public class NiukeC {
    /**
     * 两个数表示答案
     * @param n int整型 一次运输的冰激凌数量
     * @param m int整型 总冰激凌数
     * @param t int整型 一次运输的时间
     * @param c int整型一维数组 表示每个冰激凌制作好时间<1e4
     * @return int整型一维数组
     */
    public int[] icecream (int n, int m, int t, int[] c) {
        // write code here
        Arrays.sort(c);
        int times = 0;
        int[] dp = new int[m + 1];
        /*for (int i = 0; i <= m; i++) {
            dp[i] =  c[i] + t;
        }*/
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= m; i++) {
            int pre = Math.max(i - n, 0);
            dp[i] = Math.min(dp[i], Math.max(dp[pre] + t, c[i - 1]) + t);
        }
        times = m / n + 1;
        return new int[]{dp[m], times};
    }
}
