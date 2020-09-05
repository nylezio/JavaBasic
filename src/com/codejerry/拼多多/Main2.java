package com.codejerry.拼多多;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: codeJerry
 * @description:
 * K 距离 N 次数
 * N次的点数
10 2
6 3
 * @date: 2020/08/02 19:02
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List[] lists = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            lists[i] = new ArrayList<Integer>();
            for (int j = 0; j < 6; j++) {
                lists[i].add(sc.nextInt());
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
//                if (isEqual(lists[i], lists[j])) {
//                    ans++;
//                }
            }
        }
        System.out.println(ans);
    }

//    private static boolean isEqual(List<Integer> a, List<Integer> b) {
//        int n = a.size();
//
//        int a1 = 0, b1 = 0;
//        for (int i = 0; i < n; i++) {
//            if (a.get(i) == 1) {
//                a1 = i;
//            }
//            if (b.get(i) == 1) {
//                b1 = i;
//            }
//        }
//        int a2 = a1 % 2 == 1 ? a1 - 1 : a1 + 1;
//        int b2 = b1 % 2 == 1 ? b1 - 1 : b1 + 1;
//        if (!a.get(a2).equals(b.get(b2))) {
//            return false;
//        }
//        int[] a4 = new int[4];
//        int[] b4 = new int[4];
//        a.remove(a1);
//        a.remove(a2);
//        b.remove(b1);
//        b.remove(b2);
//
//        a4[0] = a.get(0);
//        a4[1] = a.get(2);
//        a4[2] = a.get(1);
//        a4[3] = a.get(3);
//        if (a1 == b1) {
//
//        }
//    }


}
