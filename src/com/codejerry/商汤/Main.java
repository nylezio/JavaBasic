package com.codejerry.商汤;

import java.util.Arrays;

/**
 * @author: codeJerry
 * @description:
 * @date: 2020/08/20 20:21
 */
public class Main {
    //     最优DFS 10ms 记忆化搜索
    int ans;
    int[][] dp;
    int[][] dirs = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    int n = 0;
    int m = 0;

    public int longest(int[][] matrix) {
        ans = 0;
        n = matrix.length;
        if (n == 0) {
            return ans;
        }
        m = matrix[0].length;
        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(matrix, i, j);
            }
        }
        return ans;
    }

    public int dfs(int[][] matrix, int i, int j) {
        if (dp[i][j] > 0) {
            return dp[i][j];
        }
        int len = 1;

        for (int[] d : dirs) {
            int x = i + d[0];
            int y = j + d[1];
            if (x >= 0 && x < n && y >= 0 && y < m && matrix[x][y] > matrix[i][j]) {
                int nextLen = 1 + dfs(matrix, x, y);
                len = Math.max(len, nextLen);
            }
        }
        dp[i][j] = len;
        ans = Math.max(ans, len);
        return len;
    }


    public int eraseOverlapIntervals(int[][] intervals) {
        int n, m;
        if (intervals == null || (n = intervals.length) == 0) {
            return 0;
        }
        if ((m = intervals[0].length) == 0) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int pre = 0, count = 0;
        for (int i = 1; i < n; i++) {
            if (intervals[pre][1] > intervals[i][0]) {
                if (intervals[pre][1] > intervals[i][1]) {
                    pre = i;
                }
                count++;
            } else {
                pre = i;
            }
        }
        return count;
    }
}
