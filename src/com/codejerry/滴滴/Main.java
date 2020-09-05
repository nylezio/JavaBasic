package com.codejerry.滴滴;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: codeJerry
 * @description:
 * @date: 2020/08/21 18:43
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        count(n);

    }

    private static void count(int n) {
        if (n == 1) {
            System.out.println(1);
            return;
        }
        long[] fibo = new long[n * n];
        fibo[0] = 1;
        fibo[1] = 1;
        for (int i = 2; i < n * n; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }
        long[][] ans = new long[n][n];
        int top = 0;
        int right = n - 1;
        int bottom = n - 1;
        int left = 0;
        int cur = n * n - 1;
        while (cur >= 0) {
            for (int i = left; i <= right; i++) {
                ans[top][i] = fibo[cur--];
            }
            if (cur < 0) {
                break;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                ans[i][right] = fibo[cur--];
            }
            if (cur < 0) {
                break;
            }
            right--;
            for (int i = right; i >= left; i--) {
                ans[bottom][i] = fibo[cur--];
            }
            if (cur < 0) {
                break;
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                ans[i][left] = fibo[cur--];
            }
            left++;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(ans[i][j]);
                if (j == n - 1) {
                    System.out.println();
                } else {
                    System.out.print(" ");
                }
            }
        }
    }
}


/**
 * Author:cafe3165
 * Date:2020-08-21
 */
class DIDI_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Long[][] FibMatric = new Long[n][n];
        List<Long> resList = Fibonacci(n * n);
        spiralOrder(FibMatric, resList);


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j < n - 1) {
                    System.out.print(FibMatric[i][j] + " ");
                } else {
                    System.out.println(FibMatric[i][j]);
                }
            }
        }
    }

    public static void spiralOrder(Long[][] matrix, List<Long> resList) {
        int index = resList.size() - 1;
        List<Integer> res = new ArrayList<>();

        int up = 0, down = matrix.length - 1, left = 0, right = matrix[0].length - 1;

        while (true) {
            for (int i = left; i <= right; i++) {
                matrix[up][i] = resList.get(index--);
            }
            if (++up > down) {
                break;
            }
            for (int i = up; i <= down; i++) {
                matrix[i][right] = resList.get(index--);
            }
            if (--right < left) {
                break;
            }
            for (int i = right; i >= left; i--) {
                matrix[down][i] = resList.get(index--);
            }
            if (--down < up) {
                break;
            }
            for (int i = down; i >= up; i--) {
                matrix[i][left] = resList.get(index--);
            }
            if (++left > right) {
                break;
            }
        }
    }

    public static List<Long> Fibonacci(int n) {
        List<Long> resList = new ArrayList<>();
        long f = 0;
        long g = 1;
        long res = f + g;
        resList.add(res);
        for (int i = 2; i <= n; i++) {
            res = f + g;
            f = g;
            g = res;
            resList.add(res);
        }

        return resList;
    }
}


