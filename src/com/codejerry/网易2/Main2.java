package com.codejerry.网易2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// 在s字符串中 a,b,c,x,y,z 字符出现偶数次的最大长度

public class Main2 {
    static Map<Character, Integer> map = new HashMap<>();
    static {
        map.put('a', 0);
        map.put('b', 1);
        map.put('c', 2);
        map.put('x', 3);
        map.put('y', 4);
        map.put('z', 5);
    }
    static Map<Integer, Integer> max = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(countLen(s));
    }

    private static int countLen(String s) {
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (check(s, i, j)) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }

    private static boolean check(String s, int l, int r) {
        if (max.containsKey(l)) {
            l = Math.max(l, max.get(l) + 1);
        }
        int[] count = new int[6];
        char[] chs = s.toCharArray();
        for (int i = l; i <= r; i++) {
            if (map.containsKey(chs[i])) {
                count[map.get(chs[i])]++;
            }
        }
        for (int i = 0; i < 6; i++) {
            if (count[i] % 2 == 1) {
                return false;
            }
        }
        max.put(l, r);
        return true;
    }
}
