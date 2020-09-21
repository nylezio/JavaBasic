package com.codejerry.字节5;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: codeJerry
 * @description:
abababab
abcabcabc
abcdefabcdef
abcdabc
abcdabcdabcdabcd
abababababababab
 * @date: 2020/09/20 19:12
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(check(s));
    }

    private static String check(String s) {
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
        if (fail[n - 1] == -1) {
            return s;
        }
        int index = fail[n - 1];
        int len = n - 1 - index;
        if (n % len != 0) {
            return s;
        }
        while (fail[index] != -1) {
            int t = fail[index];
            if (index - t != len) {
                return s;
            }
            index = t;
        }
        return s.substring(0, len);
    }




}
