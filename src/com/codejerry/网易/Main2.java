package com.codejerry.网易;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author: codeJerry
 * @description:
 * @date: 2020/08/08 15:18
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[m];
        int[] tmp = new int[m];
        for (int i = 0; i < m; i++) {
            nums[i] = sc.nextInt();
            tmp[i] = nums[i];
        }
        Arrays.sort(tmp);
        List<Integer> list = new ArrayList<>();
        int len = n - m;
        int cur = 1;
        int index = 0;
        while (len > 0) {
            if (index >= m || cur < tmp[index]) {
                list.add(cur);
                len--;
            }  else {
                index++;
            }
            cur++;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        while (true) {
            if (i < nums.length && j < list.size()) {
                if (nums[i] < list.get(j)) {
                    sb.append(nums[i]);
                    sb.append(" ");
                    i++;
                } else {
                    sb.append(list.get(j));
                    sb.append(" ");
                    j++;
                }
            } else if (i < nums.length) {
                sb.append(nums[i]);
                sb.append(" ");
                i++;
            } else if (j < list.size()) {
                sb.append(list.get(j));
                sb.append(" ");
                j++;
            } else {
                break;
            }
        }
        System.out.println(sb.substring(0, sb.length() - 1));
    }
}
