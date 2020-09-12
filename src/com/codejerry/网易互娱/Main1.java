package com.codejerry.网易互娱;

import java.util.*;

//3
// 421
// 123
public class Main1 {
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        String a = sc.next();
        String b = sc.next();
        char[] ch1 = a.toCharArray();
        char[] ch2 = b.toCharArray();
        Arrays.sort(ch2);
        System.out.println(check(ch1, ch2));

    }

    private static String check(char[] ch1, char[] ch2) {
        String ans = "-1";
        StringBuilder sb = new StringBuilder();
        boolean[] used = new boolean[n];
        for (int i = 0; i < n; i++) {
            boolean find = false;
            int start = binarySearch(ch1[i], ch2);
            start = start == -1 ? 0 : start;
            for (int j = start; j < n; j++) {
                if (ch2[j] == ch1[i] && !used[j]) {
                    sb.append(ch2[j]);
                    used[j] = true;
                    find = true;
                    break;
                }
            }
            if (!find) {
                boolean can = false;
                start = binarySearch(ch1[i], ch2);
                start = start == -1 ? 0 : start;
                for (int j = start; j < n; j++) {
                    if (ch2[j] > ch1[i] && !used[j]) {
                        sb.append(ch2[j]);
                        used[j] = true;
                        can = true;
                        break;
                    }
                }
                if (can) {
                    for (int j = 0; j < n; j++) {
                        if (!used[j]) {
                            sb.append(ch2[j]);
                        }
                    }
                    return sb.toString();
                }
            }


        }
        return ans;
    }

    private static int binarySearch(char c, char[] ch2) {
        int i = 0;
        int j = ch2.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (ch2[mid] >= c) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return j;
    }


}
