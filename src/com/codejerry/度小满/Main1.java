package com.codejerry.度小满;

import java.util.Scanner;

/**
 * @author: codeJerry
 * @description:
 * @date: 2020/09/20 20:35
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        char[] chs = new char[26];
        for (char ch: s1.toCharArray()) {
            chs[ch - 'A']++;
        }
        int ans = 0;
        for (char ch : s2.toCharArray()) {
            if (chs[ch - 'A'] > 0) {
                ans++;
                chs[ch - 'A']--;
            }
        }
        System.out.println(ans);
    }
}
