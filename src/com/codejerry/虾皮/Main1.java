package com.codejerry.虾皮;

import java.util.Scanner;

/**
 * @author: codeJerry
 * @description: "(*)"
["a", ["b", "c"], "d"]
 * @date: 2020/08/19 14:58
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
//        String[] strs = s.split(",");
//        System.out.println(Arrays.toString(strs));
        String ans = get(s);
        System.out.println(ans);

    }

    private static String get(String s) {
        if (s.length() == 2) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        int i = 1;
        while (i < len) {
            if (s.charAt(i) == ']') {
                break;
            } else if (s.charAt(i) == ' ') {
                i++;
            } else if (s.charAt(i) == ',') {
                i++;
            } else if (s.charAt(i) == '"') {
                StringBuilder t = new StringBuilder();
                i++;
                while (s.charAt(i) != '"') {
                    t.append(s.charAt(i));
                    i++;
                }
                sb.append(t);
                i++;
                sb.append("\\n");
            } else if (s.charAt(i) == '[') {
                int index = i + 1;

                while (s.charAt(index) != ']') {
                    index++;
                }
                sb.append(get(s.substring(i, index + 1)));
                i = index + 1;
                sb.append("\\n");
            }
        }
        return sb.delete(sb.length() - 2, sb.length()).toString();
    }


    public boolean checkValidString(String s) {
        // write code here
        int len = s.length();
        int l = 0;
        int r = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') {
                l++;
                r++;
            } else if (s.charAt(i) == ')') {
                if (l > 0) {
                    l--;
                }
                r--;
            } else {
                if (l > 0) {
                    l--;
                }
                r++;
            }
            if (r < 0) {
                return false;
            }
        }
        return l == 0;
    }
    public int calEncodeNumber (int length) {
        // write code here
        int[] ans = new int[length + 4];
        ans[0] = 1;
        ans[1] = 1;
        ans[2] = 2;
        ans[3] = 4;
        for (int i = 4; i <= length; i++) {
            ans[i] = (ans[i - 1] + ans[i - 2]) % 1000000369;
        }
        return ans[length];
    }
}
