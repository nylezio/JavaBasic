package com.codejerry.虾皮;

/**
 * @author: codeJerry
 * @description:
 * @date: 2020/08/12 14:53
 */
public class Main3 {

    public static String addStrings(String num1, String num2) {
        StringBuilder ans = new StringBuilder();
        char[] chs1 = num1.toCharArray();
        char[] chs2 = num2.toCharArray();
        int i = chs1.length - 1;
        int j = chs2.length - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int a = i >= 0 ? chs1[i] - '0' : 0;
            int b = j >= 0 ? chs2[j] - '0' : 0;
            int sum = carry + a + b;
            carry = sum / 10;
            ans.insert(0, sum % 10);
            i--;
            j--;
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String num1 = "78812308759876748123781826380198723";
        String num2 = "17826937618236512765307128937068123";
        System.out.println(addStrings(num1, num2));
    }
}
