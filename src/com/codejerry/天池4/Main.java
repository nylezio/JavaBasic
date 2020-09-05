package com.codejerry.天池4;

/**
 * @author: codeJerry
 * @description:
 * @date: 2020/09/05 10:03
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
//        System.out.println(main.perfectString("00000", 3));
        System.out.println(main.greatestcommonmultiple(5,8));
    }
    public int perfectString(String s, int k) {
        // Write your code here.
        int ans = 0;
        char[] chs = s.toCharArray();
        int count = 0;
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == '0') {
                count++;
                if (i == chs.length - 1 || count == k) {
                    ans++;
                    count = 0;
                }
            } else {
                if (count > 0) {
                    ans++;
                }
                count = 0;
            }

        }
        return ans;
    }

    public long greatestcommonmultiple(int a, int b) {
        // write your code here
        long min = 0;
        for (int i = b; i >= a; i--) {
            for (int j = i - 1; j > a; j--) {
                long x = i * j / gcb(i, j);
                for (int k = j - 1; k >= a; k--) {
                    long y = x * k / gcb(x, k);
                    System.out.println(y);
                    min = Math.max(min, y);
                }
            }
        }
        return min;
    }

    public long gcb(long a, long b) {
        return a == 0 ? b : gcb(b % a, a);
    }
}
