package com.codejerry.建信金科;

import javax.security.auth.callback.CallbackHandler;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        char[] chs = new char[]{'b','a','b','d','d','c','c','d'};
        char[] reset = reset(chs);
        System.out.println(Arrays.toString(reset));

    }

    public int findFriendNum(int[][] M) {
        int n;
        if ((n = M.length) == 0) {
            return 0;
        }
        int[] visited = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < visited.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }

    public static char[] reset(char[] chs) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : chs) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> q = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));
        q.addAll(map.keySet());
        char[] ans = new char[chs.length];
        int index = 0;
        while (!q.isEmpty()) {
            Character c = q.poll();
            int times = map.get(c);
            for (int i = 0; i < times; i++) {
                ans[index++] = c;
            }
        }
        return ans;
    }

}
