package com.codejerry.奇安信;

/**
 * @author: codeJerry
 * @description:
 * 全排列
 * @date: 2020/08/01 14:49
 */
public class Main1 {
    public static void main(String[] args) {
        int[] test = {1,1,2};
        Main1 main1 = new Main1();
        main1.reletive_7(test);
    }

    /**
     * 返回亲7数个数
     * @param digit int整型一维数组 组成亲7数的数字数组
     * @return int整型
     */
    int ans = 0;
    public int reletive_7 (int[] digit) {
        // write code here
        boolean[] flag = new boolean[digit.length];
        dfs(digit, 0, 0, flag);
        return ans;
    }

    private void dfs(int[] digit, int index, int sum, boolean[] flag) {
        if (index == digit.length) {
            System.out.println(sum);
            if (sum % 7 == 0) {
                ans++;
            }
            return;
        }


        for (int i = 0; i < digit.length; i++) {
            if (!flag[i]) {
                flag[i] = true;
                sum = sum * 10 + digit[i];
                dfs(digit, index + 1, sum, flag);
                flag[i] = false;
                sum -= digit[i];
                sum /= 10;
            }
        }

    }


}