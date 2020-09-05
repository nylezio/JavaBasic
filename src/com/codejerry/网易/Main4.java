package com.codejerry.网易;

import java.util.*;

/**
 * @author: codeJerry
 * @description: 3 5
 * 1 2 10
 * 1 3 5
 * 3 1 12
 * 2 3 19
 * 1 2 74
 * @date: 2020/08/08 16:08
 */
public class Main4 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] edge = new int[m][3];
        for (int i = 0; i < m; i++) {
            edge[i][0] = sc.nextInt();
            edge[i][1] = sc.nextInt();
            edge[i][2] = sc.nextInt();
        }

        Arrays.sort(edge, (a, b) -> (a[2] - b[2]));
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i <= m - n + 1; i++) {
            int[][] added = new int[n + 1][n + 1];
            int count = 0;
            for (int j = i; j < m; j++) {
                int t1 = edge[j][0];
                int t2 = edge[j][1];
                if (added[t1][t2] == 0) {
                    added[t1][t2] = 1;
                    added[t2][t1] = 1;
                    count++;
                    if (count == n - 1) {
                        ans = Math.min(ans, edge[j][2] - edge[i][2]);
                        break;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}