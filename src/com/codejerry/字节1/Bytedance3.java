package com.codejerry.字节1;

import java.util.Arrays;

/**
 * @author: codeJerry
 * @description:
 * @date: 2020/07/14 19:16
 */
public class Bytedance3 {

    public int getMin(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int ans = Integer.MAX_VALUE;
        int n = nums1.length;
        int m = nums2.length;
        int i = 0;
        int j = 0;
        while (i < n && j < m) {
            ans = Math.min(ans, Math.abs(nums1[i] - nums2[j]));
            if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        if (i == n) {
            ans = Math.min(ans, Math.abs(nums1[n - 1] - nums2[j]));
        }
        if (j == m) {
            ans = Math.min(ans, Math.abs(nums1[i] - nums2[m - 1]));
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {89, 100, 63, 75, 53};
        int[] nums2 = {95, 64, 43, 72};
        Bytedance3 bytedance3 = new Bytedance3();
        System.out.println(bytedance3.getMin(nums1, nums2));
    }

}
