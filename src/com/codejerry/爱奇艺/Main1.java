package com.codejerry.爱奇艺;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author: codeJerry
 * @description:(100)
 * @date: 2020/09/13 15:00
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(count(s));
    }

    private static int count(String s) {
        if (s == null) {
            return 0;
        }
        int n = s.length();
        if (n <= 1) {
            return n;
        }
        char[] chs = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;
        int i = -1;
        for (int j = 0; j < n; j++) {
            if (map.containsKey(chs[j])) {
                i = Math.max(i, map.get(chs[j]));
            }
            ans = Math.max(ans, j - i);
            map.put(chs[j], j);
        }
        return ans;
    }
}
