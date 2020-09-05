package com.codejerry.拼多多;

import java.util.*;

/**
 * @author: codeJerry
 * @description:
 *N 5 M 1 T 9
5 1 9
9 1
4 9
3 1
2 3
6 5
9 8

输出4
 * @date: 2020/08/02 19:30
 */
public class Main31 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int t = sc.nextInt();
        if (t == 0) {
            System.out.println(0);
        } else {
            List<int[]> x = new ArrayList<>();
            List<int[]> y = new ArrayList<>();

            int ans = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                int x1 = sc.nextInt();
                int x2 = sc.nextInt();
                if (x2 >= t) {
                    ans = Math.min(ans, x1);
                } else {
                    x.add(new int[]{x1, x2});
                }
            }
            for (int i = 0; i < m; i++) {
                int y1 = sc.nextInt();
                int y2 = sc.nextInt();
                if (y2 >= t) {
                    ans = Math.min(ans, y1);
                } else {
                    x.add(new int[]{y1, y2});
                }
            }

            Collections.sort(x, (a, b) -> a[1] - b[1]);
            Collections.sort(y, (a, b) -> a[1] - b[1]);

            for (int i = 0; i < x.size(); i++) {
                for (int j = 0; j < y.size(); j++) {
                    if (x.get(i)[1] + y.get(j)[1] >= t) {
                        ans = Math.min(ans, x.get(i)[0] + y.get(j)[0]);
                    }
                }
            }
            if (ans == Integer.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(ans);
            }
        }

    }
}
