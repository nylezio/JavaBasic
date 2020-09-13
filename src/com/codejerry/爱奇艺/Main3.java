package com.codejerry.爱奇艺;

import java.util.*;

/**
 * @author: codeJerry
 * @description: (100)
 * @date: 2020/09/13 15:00
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (sc.hasNext()) {
            list.add(sc.nextInt());
        }
        Collections.sort(list);
        count(list);
    }

    private static void count(List<Integer> list) {
        if (list.size() < 3) {
            return;
        }
        int n = list.size();
        for (int i = 0; i < n - 3; i++) {
            if (list.get(i) > 0) {
                break;
            }
            if (i != 0 && list.get(i).equals( list.get(i - 1))) {
                continue;
            }
            if (list.get(i) + list.get(i + 1) + list.get(i + 1) > 0) {
                break;
            }
            int j = i + 1;
            int k = n - 1;
            int t = list.get(i);
            while (j < k) {
                int sum = list.get(i) + list.get(j) + list.get(k);
                if (sum == 0) {
                    System.out.print("" + t + " " + list.get(j) + " " + list.get(k));
                    System.out.println();
                    j++;
                    while (j < k && list.get(j).equals( list.get(j - 1))) {
                        j++;
                    }
                    k--;
                    while (j < k && list.get(k).equals( list.get(k + 1))) {
                        k--;
                    }
                } else if (t + list.get(j) + list.get(k) < 0) {
                    j++;
                    while (j < k && list.get(j).equals( list.get(j - 1))) {
                        j++;
                    }
                } else {
                    k--;
                    while (j < k && list.get(k).equals( list.get(k + 1))) {
                        k--;
                    }
                }
            }
        }
    }


}
