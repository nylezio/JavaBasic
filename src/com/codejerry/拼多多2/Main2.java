package com.codejerry.拼多多2;

import java.util.*;

public class Main2 {

    static int N;
    static int M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        int count = 0;
        int[][] grid = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                grid[i][j] = sc.nextInt();
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        int ans = larg(grid);
        ans = ans == count + 1 ? count : ans;
        System.out.println(ans);

    }

    private static int larg(int[][] grid) {
        int index = 2;
        int[] area = new int[N * M + 2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 1) {
                    area[index] = dfs(i, j, index++, grid);
                }
            }
        }
        int ans = 0;
        for (int x : area) {
            ans = Math.max(ans, x);
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> seen = new HashSet<>();
                    for (int move : neighbor(i, j, grid)) {
                        if (grid[move / M][move % M] > 1) {
                            seen.add(grid[move / M][move % M]);
                        }
                    }
                    int bns = 1;
                    for (int k : seen) {
                        bns += area[k];
                    }
                    ans = Math.max(ans, bns);
                }
            }
        }
        return ans;
    }

    private static List<Integer> neighbor(int i, int j, int[][] grid) {
        int[] dr = new int[]{-1, 0, 1, 0};
        int[] dc = new int[]{0, -1, 0, 1};
        List<Integer> ans = new ArrayList<>();
        for (int k = 0; k < 4; k++) {
            int nr = i + dr[k];
            int nc = j + dc[k];
            if (0 <= nr && nr < N && 0 <= nc && nc < M) {
                ans.add(nr * M + nc);
            }
        }
        return ans;
    }

    private static int dfs(int i, int j, int index, int[][] grid) {
        int ans = 1;
        grid[i][j] = index;
        for (int move : neighbor(i, j, grid)) {
            if (grid[move / M][move % M] == 1) {
                grid[move / M][move % M] = index;
                ans += dfs(move / M, move % M, index, grid);
            }
        }
        return ans;
    }

}
