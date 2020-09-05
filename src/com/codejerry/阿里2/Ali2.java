package com.codejerry.阿里2;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: codeJerry
 * @description:
 * 多重背包问题
 * 有个藏宝架有n层，每层的宝物数量不一，每个宝物都有其价值，现在要求拿出m个宝物，并且需要遵守规则：
 * 每次只能拿选定层的两端的宝物要拿出的m个宝物的总价值是各种方案里最大的
 * 输入： n m
 * 下面每行代表每层，且第一个数是这层宝物的数量k，后面的则是k个宝物的价值
2 3
2 3 2
4 1 4 1 5
 * @date: 2020/07/17 18:51
 */
public class Ali2 {


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        List<int[]> list = new LinkedList<>();
        for (int j = 0; j < n; j++){
            int k = in.nextInt();
            int[] arr = new int[k];
            for (int i = 0; i < k; i++){
                arr[i] = in.nextInt();
            }
            list.add(arr);
        }
        List<int[]> cur = new LinkedList<>();
//        先用滑动窗口生成每一行取0-m个对应的最大值的一个矩阵 M：(m + 10) * n
        helper(list, m, cur);
//之后做一个（m + 1）* n 的dp表：
//类似背包的思想，从上往下，一层一层拿：
//先只拿第一层：
//0 3 5 5
//（意义就是只拿第一层的时候，取的个数与对应最大总价值）
//再加入第二层：
//0 3 5 5
//0 5 8 10
//
//转移方程：dp[i] [j] = max( p[i-1] [j-k] + M[i] [k], dp[i-1] [j]) (0 <= k <= j)
        int res = helper(cur, m, n);
        System.out.println(res);
    }

    private static int helper(List<int[]> cur, int m, int n){
        int[][] dp = new int[n][m + 1];
        for (int i = 0; i < n; i++){
            for (int j = 0; j <= m; j++){
                if (i == 0 && j != 0) {
                    dp[i][j] = cur.get(0)[j-1];
                }else if (j == 0) {
                    dp[i][j] = 0;
                }else {
                    int curMax = dp[i-1][j];
                    for (int k = 0; k <= j; k++){
                        curMax = Math.max(curMax, dp[i-1][j-k] + cur.get(i)[k]);
                    }
                    dp[i][j] = curMax;
                }
            }
        }
        return dp[n-1][m];

    }

    private static void helper(List<int[]> list, int m, List<int[]> resList){
        for (int[] cur : list){
            resList.add(genRow(cur, m));
        }
    }

    private static int[] genRow(int[] arr, int m){
        int[] res = new int[m+1];
        res[0] = 0;
        for (int i = 1; i <= m; i++){
            res[i] = maxSum(arr, i);
        }
        return res;
    }

    private static int maxSum(int[] arr, int m){
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        if (m > arr.length) {
            return sum;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i <= m; i++){
            int cur = 0;
            for (int j = 0; j < arr.length - m; j++){
                cur += arr[i+j];
            }
            res = Math.min(res, cur);
        }
        return sum - res;
    }
}