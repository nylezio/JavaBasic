package com.codejerry.顺丰;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println(f(n, arr));
        }
    }

    private static int f(int n, int[] num) {
        int i = 0;
        int ans = 0;
        while (i < n) {
            ans += 1;
            int i1 = i;
            while (i1 < n && num[i1] == -1) {
                i1++;
            }
            if (i1 == n) {
                break;
            }
            int i2 = i1 + 1;
            while (i2 <n && num[i2] == -1) {
                i2++;
            }
            if (i2 == n) {
                break;
            }
            int dist = i2 - i1;
            int step = (num[i2] - num[i1]) / dist;
            if ((num[i2] - num[i1]) % dist != 0) {
                i = i2;
                continue;
            }
            int i3 = i2 + 1;
            while (i3 < n) {
                int nxt = num[i2] + step * (i3 - i2);
                if (nxt <= 0 || (num[i3] != -1 && num[i3] != nxt)) {
                    break;
                }
                i3 += 1;
            }
            i = i3;
        }
        return ans;
    }

}