package com.codejerry.百度;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: codeJerry
 * @description:
 * @date: 2020/09/03 19:41
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            List<int[]> list = new ArrayList<>();
            list.add(new int[]{1, n});
            int m = sc.nextInt();
            for (int j = 0; j < m; j++) {
                int mNums = sc.nextInt();
                for (int k = 0; k < mNums; k++) {
                    int l = sc.nextInt();
                    int r = sc.nextInt();

                }
            }

            int count = 0;
            for (int[] t : list) {
                count += t[1] - t[0] + 1;
            }
            System.out.println(count);
            for (int[] t : list) {
                for (int k = t[0]; k <= t[1]; k++) {
                    System.out.print(k + " ");
                }
            }
        }
    }

}
