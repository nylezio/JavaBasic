package com.codejerry.力扣;

import java.util.*;

/**
 * @author: codeJerry
 * @description:
 * @date: 2020/08/26 16:16
 */
public class Main {
    /**
     * 227基本计算器II
     *
     * @param s 字符串
     * @return 最终的值
     */
    public int calculate(String s) {
        String s1 = s.trim();
        char[] chs = s1.toCharArray();
        char type = '+';
        Deque<Integer> stack = new ArrayDeque<>();
        int cur = 0;
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == ' ') {
                continue;
            }
            if (Character.isDigit(chs[i])) {
                cur = cur * 10 + (chs[i] - '0');
            }
            if (i == chs.length - 1 || chs[i] == '+' || chs[i] == '-' || chs[i] == '*' || chs[i] == '/') {
                if (type == '+') {
                    stack.push(cur);
                } else if (type == '-') {
                    stack.push(-cur);
                } else if (type == '*') {
                    stack.push(stack.pop() * cur);
                } else {
                    stack.push(stack.pop() / cur);
                }
                cur = 0;
                type = chs[i];
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.poll();
        }
        return ans;
    }

    /**
     * 和大于等于K的最短子数组
     *
     * @param A
     * @param K
     */
    public int shortestSubarray(int[] A, int K) {
        int ans = Integer.MAX_VALUE;
        TreeMap<Long, Integer> sumDataMap = new TreeMap<>();
        long sum = 0;
        long smallSum = A[0];
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= K) {
                return 1;
            }
            sum += A[i];
            if (sum >= K) {
                ans = Math.max(ans, i + 1);
            }
            long sub = sum - K;
            while (!sumDataMap.isEmpty()) {
                Map.Entry<Long, Integer> entry = sumDataMap.floorEntry(sub);
                if (entry == null) {
                    break;
                }
                long key = entry.getKey();
                int j = entry.getValue();
                sumDataMap.remove(key);
                if (i - j < ans) {
                    ans = i - j;
                }
            }
            if (sum < smallSum) {
                sumDataMap.clear();
                smallSum = sum;
            }
            sumDataMap.put(sum, i);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }


}

