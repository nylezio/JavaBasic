package com.codejerry.天池2;

import java.util.*;

/**
 * @author: codeJerry
 * @description:
 * @date: 2020/08/29 14:10
 */
public class Main {

    /**
     * @param trees: the positions of trees.
     * @param d:     the minimum beautiful interval.
     * @return: the minimum number of trees to remove to make trees beautiful.
     */
    public int treePlanning(int[] trees, int d) {
        // write your code here.
        int n = trees.length;
        if (n <= 1) {
            return 0;
        }
        int pre = trees[0];
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (trees[i] - pre < d) {
                ans++;
            } else {
                pre = trees[i];
            }
        }
        return ans;
    }

    /**
     * @param lengths: the lengths of sticks at the beginning.
     * @return: return the minimum number of cuts.
     */
    public int makeEquilateralTriangle(int[] lengths) {
        // write your code here.
        Arrays.sort(lengths);
        int len = lengths.length;
        int ans = 2;
        if (lengths[len - 1] >= lengths[0] * 2) {
            if (lengths[len - 1] == lengths[0] * 2) {
                ans = 1;
            }
        }
        Set<Integer> set = new HashSet<>();
        set.add(lengths[0]);
        for (int i = 1; i < len; i++) {
            if (lengths[i] % 2 == 0) {
                if (set.contains(lengths[i] / 2)) {
                    ans = 1;
                }
            }
            if (lengths[i] == lengths[i - 1]) {

                if (i > 1) {
                    if (lengths[i] == lengths[i - 2]) {
                        return 0;
                    }
                }
                if (i != len - 1) {
                    ans = 1;
                }
            }
            set.add(lengths[i]);
        }
        return ans;
    }


    /**
     * @param s: a string.
     * @return: return the values of all the intervals.
     */
    public long suffixQuery(String s) {
        // write your code here

        int n = s.length();
        long[][] dp = new long[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    long l = dp[j + 1][i - 1];
                    if (l == i - j - 1) {
                        dp[j][i] = l + 2;
                    } else {
                        dp[j][i] = l + 1;
                    }
                }
            }
        }

        long ans = 0;
        for (long[] lo : dp) {
            for (long l : lo) {
                ans += l;
            }
        }
        return ans;
    }


    /**
     * @param heights: the heights of buildings.
     * @param k:       the vision.
     * @param x:       the energy to spend of the first action.
     * @param y:       the energy to spend of the second action.
     * @return: the minimal energy to spend.
     */
    public long shuttleInBuildings(int[] heights, int k, int x, int y) {
        // write your code here.
        Deque<Integer> stack = new ArrayDeque<>();
        int[] next = new int[heights.length];
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] < heights[i]) {
                stack.pop();
            }
            next[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        long[] dp = new long[heights.length + 1];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < heights.length; i++) {
            if (next[i] != -1 && next[i] - i <= k) {
                dp[next[i]] = Math.min(dp[next[i]], dp[i] + x);
            }
            if (i + 1 < heights.length) {
                dp[i + 1] = Math.min(dp[i] + y, dp[i + 1]);
            }
            if (i + 2 < heights.length) {
                dp[i + 2] = Math.min(dp[i] + y, dp[i + 2]);
            }

        }
        return dp[heights.length - 1];
    }


    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.suffixQuery("aba"));
    }
}