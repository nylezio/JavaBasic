package com.codejerry.携程1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 you
 i love you,oyu love me
 jack
 */
public class Main {
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pre = sc.nextLine();
        String s = sc.nextLine();
        String next = sc.nextLine();
        dfs(pre.toCharArray(), 0, pre.length() - 1);
//        System.out.println(set.toString());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ) {
            if (i + pre.length() <= s.length() && set.contains(s.substring(i, i + pre.length()))) {
                sb.append(next);
                i += pre.length();
            } else {
                sb.append(s.charAt(i));
                i++;
            }
        }
        System.out.println(sb.toString());
    }

    private static void dfs(char[] chs, int f, int t) {
        if (f > t || f < 0) {
            return;
        }
        if (f == t) {
            set.add(String.valueOf(chs));
        }
        for (int i = f; i <= t; i++) {
            swap(chs, i, f);
            dfs(chs, f + 1, t);
            swap(chs, i, f);
        }
    }

    private static void swap(char[] chs, int i, int f) {
        char t = chs[i];
        chs[i] = chs[f];
        chs[f] = t;
    }


}
