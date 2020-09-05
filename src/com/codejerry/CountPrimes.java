package com.codejerry;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: codeJerry
 * @description:
 * 统计[2,n]之间的素数个数
 * @date: 2020/08/07 15:18
 */
public class CountPrimes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]){
                count++;
            }
        }
        System.out.println(count);
    }

    /**
     * 判断整数 n 是否是素数
     */
    boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                // 有其他整除因子
            {
                return false;
            }
        }
        return true;
    }
}
