package com.codejerry.华为;

import java.util.Scanner;

/**
 * @author: codeJerry
 * @description:
2
3 5
1 0 1 0 0
0 1 1 0 1
0 0 1 0 1
 * @date: 2020/08/12 19:35
 */
public class Main1 {
    static int s;
    static int m;
    static int n;
    static boolean[][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.nextInt();
        m = sc.nextInt();
        n = sc.nextInt();
        int[][] matrix = new int[m][n];
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        if (matrix[0][0] == 0 || matrix[m - 1][n - 1] == 0) {
            System.out.println(0);
        } else {
            if (dfs(matrix, 0, 0)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }

    }

    private static boolean dfs(int[][] matrix, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || matrix[i][j] == 0) {
            return false;
        }
        if (i == m - 1 && j == n - 1) {
            return true;
        }
        visited[i][j] = true;
        boolean can = false;
        for (int k = -s; k < s; k++) {
            can = can || dfs(matrix, i + k, j + s - k);
        }
        return can;
    }

}
