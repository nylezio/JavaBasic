package com.codejerry.有赞;

/**
 * @author: codeJerry
 * @description: 找和为5的倍数的最大值
 * {1,2,3,4,4}
 * 10
 * {3,6,5,1,8}
 * 20
 * @date: 2020/08/20 19:15
 */
public class Main {
    public static void main(String[] args) {
//        int[] nums = new int[]{1,2,3,4,4};
        int[] nums = new int[]{3, 6, 5, 1, 8};
        Main main = new Main();
        main.maxSum(nums);
        System.out.println(ans);
    }

    static int ans = 0;

    public int maxSum(int[] nums) {
        dfs(nums, 0, 0);
        return ans;
    }

    private void dfs(int[] nums, int index, int cur) {
        if (cur % 5 == 0) {
            ans = Math.max(ans, cur);
        }
        if (index == nums.length) {
            return;
        }
        dfs(nums, index + 1, cur);
        cur += nums[index];
        dfs(nums, index + 1, cur);

    }
}
