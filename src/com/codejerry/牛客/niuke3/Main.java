package com.codejerry.牛客.niuke3;

import java.util.*;

/**
 * @author: codeJerry
 * @description:
 * @date: 2020/08/13 20:59
 */
public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        Point point1 = new Point(1, 2);
        Point point2 = new Point(2, 3);
        Point[] ps = new Point[2];
        ps[0] = point1;
        ps[1] = point2;

        System.out.println(main.solve(3, 2, ps));
    }
    public String solve(String str) {
        // write code here
        char[] chs = str.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : chs) {
            char t = ch;
            while (!stack.isEmpty() && t == stack.peek() && t != '2') {
                if (t == '0') {
                    stack.pop();
                    t = '1';
                } else {
                    stack.pop();
                    t = '2';
                    if (!stack.isEmpty()) {
                        t = stack.pop();
                    }
                }
            }
            if (t != '2') {
                stack.push(t);
            }
        }
        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ans.insert(0, stack.pop());
        }
        return ans.toString();
    }


    public static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    Map<Integer, Set<Integer>> map = new HashMap<>();
    public int solve(int n, int m, Point[] limit) {
        // write code here

        if (n == 1) {
            return 2;
        }

        for (int i = 0; i < m; i++) {
            int a = limit[i].x;
            int b = limit[i].y;
            if (!map.containsKey(a)) {
                Set<Integer> set = new HashSet<>();
                set.add(b);
                map.put(a, set);
            } else {
                Set<Integer> set = map.get(a);
                set.add(b);
            }
            if (!map.containsKey(b)) {
                Set<Integer> set = new HashSet<>();
                set.add(a);
                map.put(b, set);
            } else {
                Set<Integer> set = map.get(b);
                set.add(a);
            }
        }
//        for (int a : map.keySet()) {
//            System.out.println(a);
//            System.out.println(map.get(a));
//        }
        List<Set<Integer>> list = new ArrayList<>();
        list.add(new HashSet<>());

        for (int i = 1; i <= n; i++) {

            int k = list.size();
            for (int j = 0; j < k; j++) {
                Set<Integer> set = list.get(j);
                if (!set.contains(i)) {
                    boolean can = true;
                    for (int a : map.get(i)) {
                        if (set.contains(a)) {
                            can = false;
                            break;
                        }
                    }
                    if (can) {
                        Set<Integer> s = new HashSet<>(set);
                        s.add(i);
                        list.add(s);
                    }
                }
            }
        }
//        System.out.println(Arrays.toString(list.toArray()));
        return list.size();
    }

}
