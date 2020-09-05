package com.codejerry.网易;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author: codeJerry
 * @description:
3
5 7 3
 * @date: 2020/08/08 14:54
 */
public class Main1 {
    public  static Map<Integer, Long> map = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            ans += getPrime(k);
        }
        System.out.println(ans);
    }

    private static long getPrime(int k) {
        if (map.containsKey(k)) {
            return map.get(k);
        }
        long count = 0;
        if (k == 1) {
            return 0;
        }
        if (k == 2) {
            return 1;
        }
        long t = 0;
        if (isPrime(k)) {
            t = 1;
        }
        for (int i = 1; i <= k / 2 + 1; i++) {
            t = Math.max(t, getPrime(k - i) + getPrime((i)));
        }
        map.put(k, count);
        return count;
    }

    private static boolean isPrime(int k) {
        if (k <= 1) {
            return false;
        }
        for (int i = 2; i * i <= k; i++) {
            if (k % i == 0) {
                return true;
            }
        }
        return false;
    }

}
