package com.codejerry.用友;

import java.util.*;

/**
 * @author: codeJerry
 * @description:
 * @date: 2020/08/18 15:01
 */
public class Main {
    public static void main(String[] args) {

        int[] a = findAllCheapestPrice(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0);
        System.out.println(Arrays.toString(a));
    }


    /**
     * 现在给定所有的城市和航班，以及出发城市src，你的任务是找到从 scr城市出发到其他所有城市最便宜的机票价格列表。
     * 假设两个城市之间机票价格不会超过Integer.MAX_VALUE
     * @param n int整型
     * @param flights int整型二维数组
     * @param src int整型
     * @return int整型一维数组
     */
    public static int[] findAllCheapestPrice (int n, int[][] flights, int src) {
        // write code here
        int[] ans = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[src] = 0;
        Queue<Integer> que = new LinkedList<>();
        LinkedList<Dis>[] list = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            list[i] = new LinkedList<>();
        }
        Set<Integer> set = new HashSet<>();
        set.add(src);
        que.add(src);
        for (int[] dis : flights) {
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
            }
        }
        for (int i = 0; i < ans.length; i++) {
            if (ans[i] == Integer.MAX_VALUE) {
                ans[i] = -1;
            }
        }
        return  ans;
    }

    static class Dis {
        public int x;
        public int y;
        public Dis (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public String compress (String str) {
        // write code here
        if (str == null || str.length() == 0){
            return str;
        }
        int len = str.length();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        char c = str.charAt(0);
        for (int i = 0; i < str.length(); i++) {
            if (count == 0) {
                count++;
                c = str.charAt(i);
            } else {
                if (str.charAt(i) == c) {
                    count++;
                } else {
                    sb.append(c);
                    sb.append(count);
                    c = str.charAt(i);
                    count = 1;
                }
            }
            if (i == str.length() - 1) {
                sb.append(c);
                sb.append(count);
            }
        }
        if (sb.length() < len) {
            return sb.toString();
        } else {
            return str;
        }
    }

    public int[][] convert (int[][] matrix) {
        // write code here
        if (matrix == null || matrix.length == 0) {
            return matrix;
        }
        int i = 0;
        int j = matrix.length - 1;
        while (i < j) {
            int[] t = matrix[i];
            matrix[i] = matrix[j];
            matrix[j] = t;
            i++;
            j--;
        }
        return matrix;
    }
}
