package com.codejerry.cvte;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(findAllCheapestPrice(3, new int[][]{{0, 1, 600}, {1, 2, 500}, {0, 2, 1300}}, 0, 2));
    }

    public static int findAllCheapestPrice (int w, int[][] R, int A, int B) {
        // write code here
        int[] ans = new int[w];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[A] = 0;
        Queue<Integer> que = new LinkedList<>();
        List<Dis>[] list = new LinkedList[w];
        for (int i = 0; i < w; i++) {
            list[i] = new LinkedList<>();
        }
        Set<Integer> set = new HashSet<>();
        set.add(A);
        que.add(A);
        for (int[] dis : R) {
            list[dis[0]].add(new Dis(dis[1], dis[2]));
        }

        while (!que.isEmpty()) {
            int cur = que.poll();
            int minD = Integer.MAX_VALUE;
            int index = cur;
            for (int i = 0; i < list[cur].size(); i++) {
                Dis dis = list[cur].get(i);

                if (!set.contains(dis.x)) {
                    if (ans[cur] + dis.y < minD) {
                        minD = ans[cur] + dis.y;
                        index = dis.x;
                    }
                    ans[dis.x] = Math.min(ans[dis.x], ans[cur] + dis.y);
                }
            }
            if (index != cur) {
                que.offer(index);
                set.add(index);
                if (index == B) {
                    return ans[index];
                }
            }
        }
        return -1;
    }

    static class Dis {
        public int x;
        public int y;
        public Dis (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }





}
