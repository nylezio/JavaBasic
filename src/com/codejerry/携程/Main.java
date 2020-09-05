package com.codejerry.携程;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: codeJerry
 * @description:
 * @date: 2020/08/15 13:40
 */
public class Main {
    static boolean can = true;

    public static void main(String[] args) {
//        String s = "((ur)oi)";
        String s = "((((oi(ufd)ii)hy)lkk))";
        char[] chs = s.toCharArray();
        String ans = change(chs);
        if (!can) {
            System.out.println("");
        } else {
            System.out.println(ans);
        }
    }

    private static String change(char[] chs) {

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < chs.length; i++) {
//            如果碰到的第一个括号是')' 那肯定就错了
            if (chs[i] == ')') {
                can = false;
                return "";
            } else if (chs[i] == '('){
                int count = 1;
                for (int j = i + 1; j < chs.length; j++) {
                    if ('(' == chs[j]) {
                        count++;
                        stack.push(j);
                    } else if (')' == chs[j]) {
                        count--;
                        if (count == 0) {
                            reverse(chs, i + 1, j - 1);
                            i = j;
                            break;
                        } else {
                            int t = stack.pop();
                            reverse(chs, t + 1, j - 1);
                        }
                    }
                }
            }
        }
        int index = 0;
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] != '(' && chs[i] != ')') {
                chs[index] = chs[i];
                index++;
            }
        }
        return new String(chs, 0 , index);
    }

    private static void reverse(char[] chs, int l, int r) {
        while (l < r) {
            char t = chs[l];
            chs[l] = chs[r];
            chs[r] = t;
            l++;
            r--;
        }
    }


}
