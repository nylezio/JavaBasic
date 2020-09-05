package com.codejerry.美团1;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author: codeJerry
 * @description:
5 2
5 10
8 9
1 4
7 9
6 10
 * @date: 2020/08/22 16:15
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] order = new int[n][2];
        PriorityQueue<Integer> que = new PriorityQueue<>(m, (a, b) -> order[b][1] == order[a][1] ? order[a][0] - order[b][0]: order[b][1] - order[a][1]);
        for (int i = 0; i < n; i++) {
            order[i][0] = i;
            order[i][1] = sc.nextInt() + 2 * sc.nextInt();
            que.offer(i);
        }
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            ans[i] = que.poll() + 1;
        }
        Arrays.sort(ans);
        for (int i = 0; i < m; i++) {
            System.out.print(ans[i]);
            System.out.print(" ");
        }
    }
}
