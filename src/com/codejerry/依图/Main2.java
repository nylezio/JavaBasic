package com.codejerry.依图;

import java.util.Scanner;

/**
 * @author: codeJerry
 * @description:
2
123112111
111
 * @date: 2020/08/28 16:04
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            String s = sc.next();
            System.out.println(count(s));
        }
    }

    private static int count(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int[] map = new int[26];
        char[] chars = s.toCharArray();
        int i = 0;
        int preMax = 0;
        for (int j = 0; j < chars.length; j++) {
            int index = chars[j] - '0';
            map[index]++;
            preMax = Math.max(preMax, map[index]);
            if (j - i + 1 > preMax + 1) {
                map[chars[i] - '0']--;
                i++;
            }
        }
        return chars.length - i;

    }
}
