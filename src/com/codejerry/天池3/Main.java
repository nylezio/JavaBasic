package com.codejerry.天池3;

import java.util.List;

/**
 * @author: codeJerry
 * @description:
 * @date: 2020/08/29 14:35
 */
public class Main {

    int[][] max;
    int[][] min;

    public int Intervalxor(int[] num, List<List<Integer>> ask) {
        // write your code here
        int ans = 0;
        int n = num.length;
        max = new int[n][n];
        min = new int[n][n];
        for (List<Integer> list : ask) {
            int l1 = list.get(0) - 1;
            int r1 = list.get(1) - 1;
            int l2 = list.get(2) - 1;
            int r2 = list.get(3) - 1;
            int ma = getMax(num, l1, r1);
            int mi = getMin(num, l2, r2);
            ans ^= ma + mi;
        }
        return ans;
    }

    private int getMin(int[] num, int l2, int r2) {
        if (min[l2][r2] > 0) {
            return min[l2][r2];
        }
        int minN = Integer.MAX_VALUE;
        for (int j = l2; j <= r2; j++) {
            minN = Math.min(num[j], minN);
        }
        min[l2][r2] = minN;
        return minN;
    }

    private int getMax(int[] num, int l1, int r1) {
        if (max[l1][r1] > 0) {
            return max[l1][r1];
        }
        int maxN = -1;
        for (int j = l1; j <= r1; j++) {
            maxN = Math.max(num[j], maxN);
        }
        max[l1][r1] = maxN;
        return maxN;
    }

    public int Fivecharacterpalindrome(String s) {
        // write your code here
        int count = 0;
        for (int i = 3; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                if (s.charAt(i) != s.charAt(i - 1)) {
                    if (s.charAt(i) == s.charAt(i - 2)) {
                        if (s.charAt(i + 1) == s.charAt(i - 3)) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    public boolean containsPattern(int[] arr, int m, int k) {
        for (int i = 0; i <= arr.length - m * k; i++) {
            boolean can = true;
            for (int a = i; a < i + m; a++) {
                for (int j = 0; j < k; j++) {
                    if (arr[a + m * j] != arr[a]) {
                        can = false;
                        break;
                    }
                }
            }

            if (can) {
                return true;
            }

        }
        return false;
    }

    public int getMaxLen(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2];
        int ans = 1;
        if (nums[0] > 0) {
            dp[0][0] = 1;
        } else if (nums[0] < 0) {
            dp[0][1] = 1;
        } else {
            ans = 0;
        }

        for (int i = 1; i < n; i++) {
            if (nums[i] == 0) {
                dp[i][0] = 0;
                dp[i][1] = 0;
            } else if (nums[i] > 0) {
                dp[i][0] = dp[i - 1][0] + 1;
                dp[i][1] = dp[i - 1][1] > 0 ? dp[i - 1][1] + 1 : 0;
            } else {
                dp[i][0] = dp[i - 1][1] > 0 ? dp[i - 1][1] + 1 : 0;
                dp[i][1] = dp[i - 1][0] + 1;
            }

            ans = Math.max(ans, dp[i][0]);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
