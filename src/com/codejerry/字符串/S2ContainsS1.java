package com.codejerry.字符串;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: codeJerry
 * @description: 都是子串
 * 算法1 KMP算法，保证s2中的字符串需要与s1中的字符串完全一致
 * 算法2 双指针， 只需要s2中的字符串是s1中的一个排列
 * @date: 2020/08/31 15:22
 */

public class S2ContainsS1 {

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(checkInclusion(s1, s2));
        System.out.println(checkInclusion1(s1, s2));
    }


    /**
     * KMP
     */
    public static boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[] fail = new int[n];
        Arrays.fill(fail, -1);
        for (int i = 1; i < n; ++i) {
            int j = fail[i - 1];
            while (j != -1 && s1.charAt(j + 1) != s1.charAt(i)) {
                j = fail[j];
            }
            if (s1.charAt(j + 1) == s1.charAt(i)) {
                fail[i] = j + 1;
            }
        }
        System.out.println(Arrays.toString(fail));
        int best = -1;
        for (int i = 0; i < m; i++) {
            while (best != -1 && s1.charAt(best + 1) != s2.charAt(i)) {
                best = fail[best];
            }

            if (s1.charAt(best + 1) == s2.charAt(i)) {
                best++;
                if (best == n - 1) {
                    return true;
                }
            }
            System.out.println("i " + i);
            System.out.println("best " + best);

        }

        return false;
    }


    /**
     * 双指针
     */
    public static boolean checkInclusion1(String s, String s2) {
        int n = s.length();
        int m = s2.length();
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> map1 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        int num = 0;
        int i = -1;
        int j = 0;
        while (true) {
            while (j < m && map.containsKey(s2.charAt(j)) && map1.getOrDefault(s2.charAt(j), 0) < map.get(s2.charAt(j))) {
                map1.put(s2.charAt(j), map1.getOrDefault(s2.charAt(j), 0) + 1);
                if (map1.get(s2.charAt(j)).equals(map.get(s2.charAt(j)))) {
                    num++;
                    if (num == map.size()) {
                        return true;
                    }
                }
                j++;
            }
            if (j == m) {
                return false;
            }
            if (!map.containsKey(s2.charAt(j))) {
                map1.clear();
                i = j;
                num = 0;
                j++;
            } else {
                while (i < j && map1.get(s2.charAt(j)).equals(map.get(s2.charAt(j)))) {
                    map1.put(s2.charAt(++i), map1.get(s2.charAt(i)) - 1);
                    if (map1.get(s2.charAt(i)) == map.get(s2.charAt(i)) - 1) {
                        num--;
                    }
                }
            }

        }
    }

    /**
     * 给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。
     * 找到并返回可以用这种方式转换的最短回文串。
     * KMP
     * @param s "aacecaaa"
     * @return "aaacecaaa"
     */
    public String shortestPalindrome(String s) {

        int n = s.length();
        int[] fail = new int[n];
        Arrays.fill(fail, -1);
        for (int i = 1; i < n; ++i) {
            int j = fail[i - 1];
            while (j != -1 && s.charAt(j + 1) != s.charAt(i)) {
                j = fail[j];
            }
            if (s.charAt(j + 1) == s.charAt(i)) {
                fail[i] = j + 1;
            }
        }
        System.out.println(Arrays.toString(fail));
        int best = -1;
        for (int i = n - 1; i >= 0; i--) {
            while (best != -1 && s.charAt(best + 1) != s.charAt(i)) {
                best = fail[best];
            }
            if (s.charAt(best + 1) == s.charAt(i)) {
                best++;
            }
            System.out.println(best);
        }

        StringBuilder need = new StringBuilder(best == n - 1 ? "" : s.substring(best + 1, n));
        need.reverse().append(s);
        return need.toString();
    }

}