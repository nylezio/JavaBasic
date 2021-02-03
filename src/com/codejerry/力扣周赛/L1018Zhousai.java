package com.codejerry.力扣周赛;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class L1018Zhousai {
    public static void main(String[] args) {
        System.out.println(bestTeamScore(new int[]{4, 5, 6, 5}, new int[]{2, 1, 2, 1}));
    }


    public int maxLengthBetweenEqualCharacters(String s) {
        int ans = -1;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                ans = Math.max(ans, i - map.get(s.charAt(i)) - 1);
            } else {
                map.put(s.charAt(i), i);
            }
        }
        return ans;
    }
    /**
     * 最大递增子序列之和
     */
    public static int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[][] people = new int[n][2];
        for (int i = 0; i < n; i++) {
            people[i][0] = ages[i];
            people[i][1] = scores[i];
        }
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int ans = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < 2; j++) {
//                System.out.print(people[i][j]);
//                System.out.print(" ");
//            }
//            System.out.println();
//        }
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (people[j][1] <= people[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i] += people[i][1];
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }


}
