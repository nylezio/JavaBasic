package com.codejerry.小红书;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(change("abaccd"));
    }

    public static int change(String s) {
        int n;
        if (s == null || (n = s.length()) == 0) {
            return 0;
        }
        char[] chs = s.toCharArray();
        Map<Character, List<Integer>> map = new HashMap<>();
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[i] = 1;
            } else {
                dp[i] = dp[i - 1] + 1;
            }
            if (map.containsKey(chs[i])) {
                List<Integer> list = map.get(chs[i]);
                for (int index : list) {
                    dp[i] = Math.min(index == 0 ? 1 : dp[index - 1] + 1, dp[i]);
                }
            }
            List<Integer> list = map.getOrDefault(chs[i], new ArrayList<>());
            list.add(i);
            map.put(chs[i], list);
            System.out.println(dp[i]);
        }

        return dp[n - 1];
    }

}