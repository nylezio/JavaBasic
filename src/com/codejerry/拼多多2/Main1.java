package com.codejerry.拼多多2;


import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] nums = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    nums[i][j] = 0;
                } else if (i + j == n - 1) {
                    nums[i][j] = 0;
                } else if (n % 2 == 1 && (i == n / 2 || j == n / 2)) {
                    nums[i][j] = 0;
                } else {
                    nums[i][j] = divide(n, i, j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static int divide(int n, int i, int j) {
        float middle;
        if (n % 2 == 0) {
            middle = ((float) (n - 1) / 2);
        } else {
            middle = ((float) n) / 2;
        }
        if (i < middle) {
            if (j < middle) {
                if (i > j) {
                    return 3;
                } else {
                    return 2;
                }
            } else {
                if (i + j < n) {
                    return 1;
                } else {
                    return 8;
                }
            }
        } else {
            if (j < middle) {
                if (i + j < n) {
                    return 4;
                } else {
                    return 5;
                }
            } else  {
                if (i > j) {
                    return 6;
                } else {
                    return 7;
                }
            }
        }
    }

}
