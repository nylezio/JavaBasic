package com.codejerry.阿里天池;

import java.util.*;

/**
 * @author: codeJerry
 * @description: 会议室
 * 给定一系列会议的开始时间、结束时间[[s1,e1]，[s2,e2]，…(si < ei)及他们的价值。
 * 你在同一时刻只能参加一个会议，请问你可以获得的最大价值是多少？
 * meeting = [[10,40],[20,50],[30,45],[40,60]]
 * value = [3,6,2,4]
 * 输出: 7
 * 你可以参加第0个会议和第3个会议，总价值为3 + 4 = 7.
 * @date: 2020/08/02 14:37
 */
public class Main {
    public static void main(String[] args) {
        painttheCeiling(2,
                3,
                3,
                3,
                2,
                15);
    }

    public int maxValue(int[][] meeting, int[] value) {
        // write your code here
        int ans = 0;
        int n = meeting.length;
        int[][] meet = new int[n][3];
        for (int i = 0; i < n; i++) {
            meet[i][0] = meeting[i][0];
            meet[i][1] = meeting[i][1];
            meet[i][2] = value[i];
        }
        Arrays.sort(meet, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = meet[i][2];
            if (i != 0) {
                for (int j = 0; j < i; j++) {
                    if (meet[j][1] <= meet[i][0]) {
                        dp[i] = Math.max(dp[i], dp[j] + meet[i][2]);
                    }
                }
            }

            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }


    public static long painttheCeiling(int s0, int n, int k, int b, int m, long a) {
        // write your code here

        // write your code here
        long ans = 0;

        long[] s = new long[n];

        s[0] = s0;

        for (int i = 1; i < n; i++) {
            s[i] = (k * s[i - 1] % m + b) % m + 1L + s[i - 1];

        }

        int i = 0;
        int j = n - 1;
        while (i < n && j >= 0) {
            if (s[i] * s[j] <= a) {
                ans += j + 1L;
                i++;
            } else {
                j--;
            }
        }
        return ans;
    }

    public long getSecondDiameter(int[][] edge) {
        // write your code here
        int n = edge.length + 1;
        ArrayList<int[]>[] list = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList();
        }
        for (int[] e : edge) {
            list[e[0]].add(new int[]{e[1], e[2]});
            list[e[1]].add(new int[]{e[0], e[2]});
        }
        long[][] ans = new long[n][n];
        for (int i = 0; i < list.length; i++) {
            if (list[i].size() == 1) {
                boolean[] visited = new boolean[n];
                Queue<Integer> que = new LinkedList<>();
                que.add(i);

                while (!que.isEmpty()) {
                    int t = que.poll();
                    visited[t] = true;
                    for (int[] t1 : list[t]) {

                        ans[i][t1[0]] = ans[i][t] + t1[1];
                    }
                }
            }
        }
        return 1;
    }

}
