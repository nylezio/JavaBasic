package com.codejerry.哔哩;

import java.util.*;

/**
 * @author: codeJerry
 * @description:
 * @date: 2020/08/13 18:44
 */
public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.Game24Points(new int[]{3, 4, 5, 6}));
    }
    public boolean Game24Points (int[] arr) {
        // write code here
        boolean[] used = new boolean[4];
        return dfs(arr, 24, used, 4);

    }

    private boolean dfs(int[] arr, int sum, boolean[] used, int count) {
//        if (sum < 0) {
//            return false;
//        }
        if (sum == 0 && count == 0) {
            return true;
        }
        if (count == 0) {
            return false;
        }

        for (int i = 0; i < 4; i++) {
            if (!used[i]) {
                used[i] = true;
                int t = count - 1;
                if (dfs(arr, sum - arr[i], used, t)) {
                    return true;
                }
                if (dfs(arr, sum + arr[i], used, t)) {
                    return true;
                }
                if (sum % arr[i] == 0 && dfs(arr, sum / arr[i], used, t)) {
                    return true;
                }
                if (dfs(arr, sum * arr[i], used, t)) {
                    return true;
                }
                used[i] = false;
            }

        }
        return false;
    }

    public boolean IsValidExp (String s) {
        // write code here
        if (s == null) {
            return true;
        }
        Map<Character, Character> map = new HashMap<>(3);
        map.put(']', '[');
        map.put(')', '(');
        map.put('}', '{');
        Deque<Character> stack = new ArrayDeque<>();
        char[] chs= s.toCharArray();
        for (char ch : chs) {
            if (ch == '[' || ch == '(' || ch == '{') {
                stack.push(ch);
            } else if (!stack.isEmpty() && stack.peek().equals(map.get(ch))) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }







    public int GetCoinCount (int N) {
        // write code here
        int ans = 0;
        int sum = 1024 - N;
        int[] coins = new int[]{64, 16, 4, 1};
        for (int coin : coins) {
            ans += sum / coin;
            sum %= coin;
        }
        return ans;
    }
}
