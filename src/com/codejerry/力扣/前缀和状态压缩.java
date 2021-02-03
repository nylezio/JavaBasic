package com.codejerry.力扣;

import java.util.Arrays;

public class 前缀和状态压缩 {

    public static void main(String[] args) {

    }

    public int findTheLongestSubstring(String s) {
        int[] pos = new int[1 << 5];
        Arrays.fill(pos, -1);
        pos[0] = 0;
        int ans = 0;
        int cur = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == 'a') {
                cur ^= (1);
            } else if (ch == 'e') {
                cur ^= (1 << 1);
            } else if (ch == 'i') {
                cur ^= (1 << 2);
            } else if (ch == 'o') {
                cur ^= (1 << 3);
            } else if (ch == 'u') {
                cur ^= (1 << 4);
            }
            if (pos[cur] != -1) {
                ans = Math.max(ans, i + 1 - pos[cur]);
            } else {
                pos[cur] = i + 1;
            }
        }
        return ans;
    }
}
