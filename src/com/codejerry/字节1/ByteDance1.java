package com.codejerry.字节1;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: codeJerry
 * @description:
 *
 * 345271 1 ==> 45271
 * 2347385 4 ==> 785
 * @date: 2020/07/14 19:26
 */
public class ByteDance1 {
    public int getMaxValue(long n, int m) {
        char[] chs = String.valueOf(n).toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < chs.length; i++) {
            char temp = chs[i];
            while (!stack.isEmpty() && stack.peek() < temp) {
                if (m < 1) {
                    break;
                }
                stack.pop();
                m--;
            }
            stack.push(temp);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
        long n = 479532631;
        int m = 3 ;
        ByteDance1 byteDance1 = new ByteDance1();
        System.out.println(byteDance1.getMaxValue(n, m));
    }
}
