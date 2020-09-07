package com.codejerry.网易1;

import java.util.*;

/**
  3
  10
  0 1
  0 -1
  1 1
  1 1
  1 -1
  0 1
  2 1
  2 -1
  3 1
  3 1
  2
  3 1
  3 1
  8
  0 1
  0 1
  3 1
  3 1
  1 1
  1 1
  2 1
  0 1
 */
public class Main {
    static int[][] dir = new int[][]{
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int[] pos = new int[]{0, 0};
            Set<int[]> set = new HashSet<>();
            Map<int[], Integer> map = new HashMap<>();
            map.put(new int[]{0, 0}, 0);
            for (int j = 0; j < n; j++) {
                int walk = sc.nextInt();
                if (sc.nextInt() == 1) {
                    pos[0] += dir[walk][0];
                    pos[1] += dir[walk][1];
                    set.add(new int[]{pos[0], pos[1]});
                }
            }
            int ans = bfs(pos[0], pos[1], set);
            System.out.println(ans);
        }
    }

    private static int bfs(int x, int y, Set<int[]> set) {
        Queue<List<Integer>> que = new LinkedList<>();
        Map<List<Integer>, Integer> map = new HashMap<>();
        List<Integer> pos = new ArrayList<>();
        pos.add(0);
        pos.add(0);
        que.add(pos);
        map.put(pos, 0);
        while (!que.isEmpty()) {
            int len = que.size();
            for (int i = 0; i < len; i++) {
                List<Integer> curPos = que.poll();
                for (int k = 0; k < 4; k++) {
                    List<Integer> nextPos = new ArrayList<>();
                    nextPos.add(curPos.get(0) + dir[k][0]);
                    nextPos.add(curPos.get(1) + dir[k][1]);
                    if (set.contains(nextPos) && !map.containsKey(nextPos)) {
                        map.put(nextPos, map.get(curPos) + 1);
                        que.offer(nextPos);
                    }
                    if (nextPos.get(0) == x && nextPos.get(1) == y) {
                        return map.get(nextPos);
                    }
                }
            }
        }

        return -1;
    }
}
