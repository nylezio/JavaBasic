package com.codejerry.力扣周赛;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: codeJerry
 * @description:
 * @date: 2020/08/02 10:36
 */
public class L0802zhousai {

    public static void main(String[] args) {

    }

    /**
     * 打卡题
     */
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int ans = 0;
        int n = arr.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                if (Math.abs(arr[i] - arr[j]) <= a) {
                    for (int k = j + 1; k < n; k++) {
                        if (Math.abs(arr[j] - arr[k]) <= b) {
                            if (Math.abs(arr[i] - arr[k]) <= c) {
                                ans++;
                            }
                        }
                    }

                }
            }
        }
        return ans;
    }

    /**
     * 题目数据 保证 游戏存在赢家。
     * @param arr 由 不同 整数组成的整数数组 arr
     * @param k 整数 k
     * 每回合游戏都在数组的前两个元素（即 arr[0] 和 arr[1] ）之间进行。比较 arr[0] 与 arr[1] 的大小，
     *          较大的整数将会取得这一回合的胜利并保留在位置 0 ，较小的整数移至数组的末尾。
     *          当一个整数赢得 k个连续回合时，游戏结束，该整数就是比赛的 赢家 。
     * @return 赢得比赛的整数。
     */
    public int getWinner(int[] arr, int k) {
        if (k >= arr.length - 1) {
//            return arr.max
            Arrays.sort(arr);
            return arr[arr.length - 1];
        }
        int count = 0;
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < max) {
                    count++;
                } else {
                    max = arr[j];
                    count = 1;
                }
                if (count >= k) {
                    return max;
                }
            }
        }
        return max;
    }

    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] r = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 1) {
                    r[i] = j;
                    break;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            if (r[i] <= i) {
                continue;
            }
            int j = i + 1;
            while (r[j] > i) {
                j++;
                if (j == n) {
                    return -1;
                }
            }
            while (r[i] > i) {
                swap(r, j, j - 1);
                ans++;
                j--;
            }
        }
        return ans;
    }

    private void swap(int[] r, int j, int i) {
        int t = r[i];
        r[i] = r[j];
        r[j] = t;
    }


    /**
     * 你有两个 有序 且数组内元素互不相同的数组 nums1 和 nums2
     * 一条 合法路径 定义如下：
     * @param nums1 数组 nums1
     * @param nums2 数组 nums2
     * 从左到右遍历当前数组。
     * 如果你遇到了 nums1 和 nums2 中都存在的值，那么你可以切换路径到另一个数组对应数字处继续遍历（但在合法路径中重复数字只会被统计一次）。
     * 得分定义为合法路径中不同数字的和。
     * @return 所有可能合法路径中的最大得分。对 10^9 + 7 取余后返回。
     */
    public int maxSum(int[] nums1, int[] nums2) {
        int mod = (int) Math.pow(10, 9) + 7;
//        存取相同位置的下标
//        利用前缀和
        Map<Integer, Integer> map = new HashMap<>();
        long ans = 0;
        int n = nums1.length;
        int m = nums2.length;
        int[] sum1 = new int[n + 1];
        int[] sum2 = new int[m + 1];
        for (int i = 1; i <= n; i++) {
            sum1[i] = sum1[i - 1] + nums1[i - 1];
            map.put(nums1[i - 1], i - 1);
        }
        int index1 = 0;
        int index2 = 0;
        for (int i = 1; i <= m; i++) {
            int j = i - 1;
            sum2[i] = sum2[i - 1] + nums2[j];
            if (map.containsKey(nums2[j])) {
                int k = map.get(nums2[j]);
                ans += countMax(sum1, index1, k, sum2, index2, j);
                index1 = k;
                index2 = j;
            }
        }
        ans += countMax(sum1, index1, n, sum2, index2, m);
        return (int) ans % mod;
    }

    private int countMax(int[] sum1, int index1, int i1, int[] sum2, int index2, int i2) {
        int max = Integer.MIN_VALUE;
        max = Math.max(sum1[i1] - sum1[index1], max);
        max = Math.max(sum2[i2] - sum2[index2], max);
        return max;
    }

}
