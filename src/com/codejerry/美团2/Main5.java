package com.codejerry.美团2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: codeJerry
 * @description:(100)
 * @date: 2020/09/13 11:45
 */
public class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] nums = new int[n][3];
        for (int i = 0; i < n; i++) {
            nums[i][0] = sc.nextInt();
            nums[i][1] = sc.nextInt();
            nums[i][2] = i + 1;
        }
        Arrays.sort(nums, (a, b) -> (a[1] == b[1] ? b[0] - a[0] : b[1] - a[1]));
        for (int i = 0; i < n; i++) {
            System.out.print(nums[i][2]);
            if (i != n - 1){
                System.out.print(" ");
            }
        }

    }
}
