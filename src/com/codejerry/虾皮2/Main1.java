package com.codejerry.虾皮2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author: codeJerry
 * @description:
 abccccdd
 * @date: 2020/08/26 15:01
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] chs = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c: chs) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        boolean odd = false;
        int ans = 0;
        for (char c: map.keySet()) {
            int cur = map.get(c);
            if (cur % 2 == 0) {
                ans  += cur;
            } else {
                odd = true;
                ans += cur / 2 * 2;
            }
        }
        if (odd) {
            ans += 1;
        }
        System.out.println(ans);
    }
}
