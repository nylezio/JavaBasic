package com.codejerry.腾讯;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author: codeJerry
 * @description: 5 3
 * 1 2 3 4 5
 * @date: 2020/08/23 19:56
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int i = 0;
        while (i < t) {
            long n = sc.nextLong();
            long tmp = get(n);
            long ans = cal(tmp - 1) + cal(n % tmp + 1);
            System.out.println(ans);
            i++;
        }
    }

    private static long cal(long n) {
        long ans = 0;
        while (n > 0) {
            ans += n % 10;
            n /= 10;
        }
        return ans;
    }


    private static long get(long n) {
        long ans = 1;
        while (n > 10) {
            n /= 10;
            ans *= 10;
        }
        return ans * n;
    }

    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for (int i = 1; i <= len; i++) {
            if (len % i == 0) {
                String t = s.substring(0, i);
                int cur = i;
                while (cur < len) {
                    if (t.equals(s.substring(cur, cur + i))) {
                        cur += i;
                    } else {
                        break;
                    }
                    if (cur == len) {
                        return true;
                    }
                }
            }
        }
        return false;
    }




    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        int i = 0;
        for (; i < k; i++) {
            queue.add(arr[i]);
        }
        for (; i < arr.length; i++) {
            queue.add(arr[i]);
            queue.poll();
        }
        int[] ans = new int[k];
        int index = 0;
        while (!queue.isEmpty()) {
            ans[index] = queue.poll();
            index++;
        }
        return ans;
    }

}
