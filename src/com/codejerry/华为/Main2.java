package com.codejerry.华为;

import java.util.Scanner;

/**
 * @author: codeJerry
 * @description:
EVERYTHINGGOESWELL,5
 * @date: 2020/08/12 19:35
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(",");
        System.out.println(change(strs[0], strs[1]));
    }

    private static String change(String str, String numsN) {
        int n = Integer.parseInt(numsN);
        StringBuilder[] sbs = new StringBuilder[n];
        char[] chs = str.toCharArray();
        int index = 0;
        boolean dir = true;
        for (char ch : chs) {
            if (sbs[index] == null) {
                sbs[index] = new StringBuilder();
            }
            sbs[index].append(ch);
            if (index < n / 2) {
                index = n - 1 - index;
            } else if (index == n / 2) {
                index--;
                dir = index == 0;
            } else if (index > n / 2) {
                if (dir) {
                    index = n - index;
                } else {
                    index = n - index - 2;
                    if (index == 0) {
                        dir = true;
                    }
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            ans.append(sbs[i]);
        }
        return ans.toString();
    }

}
