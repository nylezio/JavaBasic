package com.codejerry.拼多多2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author: codeJerry
 * @description:\
10 2
2
3
 * @date: 2020/09/01 19:41
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[m];
        for (int i = 0; i < m; i++) {
            nums[i] = sc.nextInt();
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 1; j <= n; j++) {
                if (nums[i] * j <= n) {
                    set.add(nums[i] * j);
                } else if (nums[i] * j > n) {
                    break;
                }
            }

        }
        System.out.println(set.size());
    }
}
