package com.codejerry.科大讯飞;

import java.util.Scanner;

/**
 * @author: codeJerry
 * @description:
 * 5 2 2 3 5
 * 55
 * @date: 2020/07/31 13:08
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        quickSort(nums, 0, n - 1);
    }

    private static void quickSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int temp = nums[l];
        int i = l;
        int j = r;
        while (true) {
            while (i < r && nums[i] <= temp) {
                i++;
            }
            while (j > l && nums[j] >= temp) {
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, l, j);
        for (int k = 0; k < nums.length; k++) {
            System.out.print(nums[k] + " ");
        }
        System.out.println();
        quickSort(nums, l, j - 1);
        quickSort(nums, j + 1, r);
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}