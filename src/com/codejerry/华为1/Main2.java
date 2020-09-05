package com.codejerry.华为1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author: codeJerry
 * @description:
4
1 0 2 2
 * @date: 2020/08/19 19:06
 */
public class Main2 {
    public static void main(String[] args) {
        int mod = (int) Math.pow(10, 9) + 7;
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] c = new int[1010][1010];
        for (int i = 0; i <= n; i++) {
            c[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                c[i][j] = (c[i - 1][j] + c[i - 1][j - 1]) % mod;
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        int maxHeight = 0;
        for (int i = 0; i < n; i++) {
            int h = in.nextInt();
            map.put(h, map.getOrDefault(h, 0) + 1);
            maxHeight = Math.max(maxHeight, h);
        }

        long ans = 1;
        for (int i = 1; i <= maxHeight; i++) {
            int all = map.get(i - 1) * 2;
            int k = map.get(i);
            ans = ans * c[all][k] % mod;
        }
        System.out.println(ans);
    }


}
