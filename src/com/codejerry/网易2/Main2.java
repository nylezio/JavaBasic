package com.codejerry.网易2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *在s字符串中 a,b,c,x,y,z 字符出现偶数次的最大长度
 * 应该用前缀和+状态压缩
 */

public class Main2 {
    static Map<Character, Integer> map = new HashMap<>();
    static {
        map.put('a', 1);
        map.put('b', 2);
        map.put('c', 4);
        map.put('x', 8);
        map.put('y', 16);
        map.put('z', 32);
    }
    static Map<Integer, Integer> seen = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        seen.put(0, -1);
        System.out.println(countLen(s));
    }

    private static int countLen(String s) {
        int ans = 0;
        int cur = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(s.charAt(i))) {
                cur ^= map.get(s.charAt(i));
            }
            if (seen.containsKey(cur)) {
                ans = Math.max(ans, i - seen.get(cur));
            } else {
                seen.put(cur, i);
            }
        }
        return ans;
    }

}
