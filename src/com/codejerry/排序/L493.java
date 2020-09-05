package com.codejerry.排序;

import java.util.Arrays;

/**
 * @author: codeJerry
 * @description:
 * @date: 2020/07/26 00:35
 */
public class L493 {
    public static int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        return mergeSort(nums, 0, nums.length - 1);
    }
    public static int mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return 0;
        }

        int mid = l + ((r - l) >> 1);
        int count1 = mergeSort(nums, l, mid);
        int count2 = mergeSort(nums, mid + 1, r);

        int count = 0;
        int[] temp = new int[r - l + 1];
        int i = l;
        int j = mid + 1;
        int index = 0;
        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j]) {
                temp[index++] = nums[i++];
            } else {
                int t = nums[j];
                int in = find(nums, i, mid, t);
                count += mid + 1 - in;
                temp[index++] = nums[j++];
            }
        }
        while (i <= mid) {
            temp[index++] = nums[i++];
        }
        while (j <= r) {
            temp[index++] = nums[j++];
        }
        for (int k = 0; k < r - l + 1; k++) {
            nums[k + l] = temp[k];
        }
        count += count1 + count2;

        return count;
    }
    public static int find(int[] nums, int i, int j, int t) {
        if (nums[i] > 2 * t) {
            return i;
        }
        while (i <= j) {
            int mid = i + ((j - i) >> 1);
            if (nums[mid]  > 2 * t) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,2,3,1};
        System.out.println(L493.reversePairs(nums));
        System.out.println(Arrays.toString(nums));
    }
}
