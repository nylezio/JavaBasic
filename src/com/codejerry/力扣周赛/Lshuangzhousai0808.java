package com.codejerry.力扣周赛;

import java.util.*;

/**
 * @author: codeJerry
 * @description:
 * @date: 2020/08/08 22:23
 */
public class Lshuangzhousai0808 {

    public int findKthPositive(int[] arr, int k) {
        int i = 0;
        int cur = 1;
        for (int j = 0; j < arr.length; j++) {
            while (cur < arr[j]) {
                cur++;
                i++;
                if (i == k) {
                    return cur - 1;
                }
            }
            if (cur == arr[j]) {
                cur = arr[j] + 1;
            }
        }
        return cur + k - i;
    }


    public boolean canConvertString(String s, String t, int k) {
        int n = s.length();
        int m = t.length();
        if (n != m) {
            return false;
        }
        int[] op = new int[n];
        for (int i = 0; i < n; i++) {
            op[i] = (t.charAt(i) - s.charAt(i)) % 26;
            if (op[i] < 0) {
                op[i] += 26;
            }
        }
        Arrays.sort(op);
        for (int i = 0; i < n; i++) {
            if (op[i] == 0) {
                continue;
            }
            if (i == 0 && op[i] <= k) {
                continue;
            }
            if (op[i] == op[i - 1] % 26) {
                op[i] = op[i - 1] + 26;
            }
            if (op[i] > k) {
                return false;
            }

        }
        return true;
    }


    public int minInsertions(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            if (ch == '(') {
                stack.push('(');
            } else {
                if (!stack.isEmpty()) {
                    char t = stack.peek();
                    if (t == '(') {
                        stack.push(')');
                    } else {
                        stack.pop();
                        if (!stack.isEmpty()) {
                            char c = stack.peek();
                            if (c == '(') {
                                stack.pop();
                            }
                        } else {
                            stack.push(')');
                            stack.push(')');
                        }
                    }

                }
            }
        }

        int ans = 0;
        int count = 0;
        while (!stack.isEmpty()) {
            char pop = stack.pop();
            if (pop == '(') {
                if (count == 1) {
                    count = 0;
                    ans += 1;
                } else if (count == 2) {
                    count = 0;
                } else {
                    ans += 2;
                }
            } else if (pop == ')') {
                if (count == 0 || count == 1) {
                    count++;
                } else {
                    ans += 1;
                    count = 1;
                }
            }
        }
        if (count > 0) {
            int t = count % 2;
            if (t == 1) {
                ans += 2;
            }
            ans += count / 2;
        }
        return ans;
    }


    public int longestAwesome(String s) {
        return 1;
    }
}
