package com.codejerry.猿辅导;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author: codeJerry
 * @description:
4
1 4
2 3
1 2
3 4
 * 输出2
 * @date: 2020/08/01 18:54
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] c = new int[n][2];
        for (int i = 0; i < n; i++) {
            c[i][0] = sc.nextInt();
            c[i][1] = sc.nextInt();
        }
        Arrays.sort(c, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int ans = 0;
        PriorityQueue<int[]> que = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (int i = 0; i < n; i++) {
            que.add(c[i]);
            while (!que.isEmpty() && que.peek()[1] <= c[i][0]) {
                que.poll();
            }
            ans = Math.max(ans, que.size());
        }
        System.out.println(ans);
    }
}
