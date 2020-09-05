package com.codejerry.牛客.niuke1;

import java.util.*;

/**
 * @author: codeJerry
 * @description:
 * 牛牛打怪兽 起始为2耐久
 * 7,[(7,2),(6,1),(5,2),(1,2),(4,6),(6,3)],[0,0,1,0,1,0,0]
 * 输出 4
 *
 * @date: 2020/07/30 22:00
 */
public class NiukeB {


    class Point {
     int x;
     int y;
     }

    public class Solution {
        /**
         * 返回牛牛能到达终点且不被淘汰的路径数
         * @param n int整型
         * @param Edge Point类一维数组
         * @param f int整型一维数组
         * @return int整型
         */
        int ans;
        List<Integer>[] list;
        public int solve (int n, Point[] Edge, int[] f) {
            // write code here
            list = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                list[i] = new ArrayList<>();
            }
            for (Point p : Edge) {
                list[p.x - 1].add(p.y - 1);
                list[p.y - 1].add(p.x - 1);
            }
            ans = 0;
            dfs(0, -1, f[0], f);
            return ans;
        }

        private void dfs(int x, int fa, int num, int[] f) {
            int son = 0;
            if (num > 2) {
                return;
            }
            for (int i = 0; i < list[x].size(); i++) {
                int y = list[x].get(i);
                if (y == fa) {
                    continue;
                }
                son++;
                dfs(y, x, num + f[y], f);
            }
            if (son == 0 && num <= 2) {
                ans++;
            }
        }

        public int solveOfBfs (int n, Point[] Edge, int[] f) {
            List<Integer>[] list = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                list[i] = new ArrayList<>();
            }
            for (Point p : Edge) {
                list[p.x - 1].add(p.y - 1);
                list[p.y - 1].add(p.x - 1);
            }
            if (n == 1) {
                return 1;
            }
            int ans = 0;
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 0);
            Queue<Integer> que = new LinkedList<>();
            que.offer(0);
            boolean[] visited = new boolean[n];

            while(!que.isEmpty()) {
                int cur = que.poll();
                List<Integer> curL = list[cur];
                int son = 0;
                visited[cur] = true;
                for (int next : curL) {
                    if (visited[next]) {
                        continue;
                    }
                    son++;
                    int val = map.get(cur) + f[next];
                    if (val <= 2) {
                        map.put(next, val);
                        que.offer(next);
                    }
                }
                if (son == 0 && map.get(cur) <= 2) {
                    ans++;
                }
            }
            return ans;
        }
    }
}
