package com.codejerry.阿里1;

import java.util.Scanner;

/**
 * @author: codeJerry
 * @description:
 * x
 * a ^ b ^ x = Integer.MAX_VALUE
 * 求满足|a-b|最小值的a,b的组合个数
 * 就是不用管1 a^b 异或最大的一个排放就只有一种
 * 每个0有两种排法
 * 0 -> 2
 * 100 -> 16
 * @date: 2020/07/17 18:51
 */
public class Ali1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println(run(sc.nextInt()));
        }
    }

    public static long run(int x) {
        int y = Integer.MAX_VALUE ^ x;
        int count = 32;
        while (y != 0) {
            y = y & (y - 1);
            count--;
        }
        return (long) Math.pow(2, count);
    }
}
