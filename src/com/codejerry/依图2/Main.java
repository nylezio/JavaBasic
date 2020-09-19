package com.codejerry.依图2;

import java.util.Scanner;

/**
 * @author: codeJerry
 * @description:
 * @date: 2020/09/17 19:03
 */
public class Main {

    static int[][] dir = new int[][]{
            {-1, 0}, {0, 1}, {1, 0}, {0, -1}
    };
    static int[] need = new int[4];
    static int ans = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            need[3] = sc.nextInt();
            need[1] = sc.nextInt();
            need[0] = sc.nextInt();
            need[2] = sc.nextInt();
            sc.nextLine();
            char[][] matrix = new char[n][m];
            for (int j = 0; j < n; j++) {
                matrix[j] = sc.nextLine().toCharArray();
            }
            boolean[][] visited = new boolean[n][m];
            int[][] dp = new int[n][m];

//            System.out.println(dfs(matrix, n, m, 0, 0, x, y, visited, dp));
        }
    }


}

