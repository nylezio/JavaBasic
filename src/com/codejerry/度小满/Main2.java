package com.codejerry.度小满;

import java.util.Scanner;

/**
 * @author: codeJerry
 * @description: (9)
 * @date: 2020/09/20 20:35
 */
public class Main2 {

    static int[][] dir = new int[][]{
            {0, -1}, {-1, 0}, {0, 1}, {1, 0}
    };
    static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for (int k = 0; k < t; k++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            sc.nextLine();
            char[][] matrix = new char[n][m];
            for (int i = 0; i < n; i++) {
                matrix[i] = sc.nextLine().toCharArray();
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (matrix[i][j] == '@') {
                        int[][] dp = new int[n][m];
                        check(matrix, n, m, i, j, dp);
                        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
                    }
                }
            }
        }

    }

    private static void check(char[][] matrix, int n, int m, int i, int j, int[][] dp) {
        ans = Integer.MAX_VALUE;
        boolean[][] visited = new boolean[n][m];
        dfs(matrix, n, m, i, j, 0, visited, dp);
    }

    private static void dfs(char[][] matrix, int n, int m, int i, int j, int cur, boolean[][] visited, int[][] dp) {
//        System.out.print(i + " " + j);
//        System.out.println();

        if (i < 0 || i >= n || j < 0 || j >= m) {
            ans = Math.min(ans, cur);
            return;
        }

        if (matrix[i][j] == '#' || visited[i][j]) {
            return;
        }
        if (matrix[i][j] == '*') {
            cur++;
        }
        if (dp[i][j] != 0) {
            if (cur >= dp[i][j]) {
                return;
            }
        }

        dp[i][j] = cur;
        for (int k = 0; k < 4; k++) {
            visited[i][j] = true;
            dfs(matrix, n, m, i + dir[k][0], j + dir[k][1], cur, visited, dp);
            visited[i][j] = false;
        }


    }
}
