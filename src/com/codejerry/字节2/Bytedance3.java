package com.codejerry.字节2;

import java.util.Arrays;

/**
 * @author: codeJerry
 * @description:
 * 最大正整数
 * @date: 2020/07/14 19:16
 */
public class Bytedance3 {

    public int getMax(int n) {
        int ans = 0;
        char[] chars = String.valueOf(n).toCharArray();
        int len = chars.length;
        char[] chars1 = Arrays.copyOf(chars, len);
        for (int i = len - 1; i > 0; i--) {
            if (chars[i] > chars[i - 1]) {
                swap(chars,i - 1, i);
            }
        }
        int j = 0;
        int index = 0;
        for (int i = 0; i < len; i++) {
            if (chars[i] != chars1[i]) {
                j = i;
                while (chars[j + 1] == chars1[j]) {
                    j++;
                }
                index = i;
                break;
            }
        }
        swap(chars1, index, j);

        ans = Integer.parseInt(String.valueOf(chars1));
        return ans;
    }
    public void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    public static void main(String[] args) {
        int n = 986581;
        Bytedance3 bytedance3 = new Bytedance3();
        System.out.println(bytedance3.getMax(n));
    }

}
