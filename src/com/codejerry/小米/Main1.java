package com.codejerry.小米;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author: codeJerry
 * @description:
 * @date: 2020/09/15 19:24
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] chs = sc.nextLine().toCharArray();
//        System.out.println(Arrays.toString(chs));
        Set<Character> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chs.length; i++) {
            if (!set.contains(chs[i])) {
                sb.append(chs[i]);
            }
            set.add(chs[i]);
        }
        System.out.println(sb);

    }
}
