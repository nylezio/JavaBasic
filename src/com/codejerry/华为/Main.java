package com.codejerry.华为;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: codeJerry
 * @description:
5,5,5,10
 * @date: 2020/08/12 19:35
 */
public class Main {
    static int[] count = new int[3];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(",");
        System.out.println(Arrays.toString(strs));
        boolean success = true;
        for (int i = 0; i < strs.length; i++) {
            int t = Integer.parseInt(strs[i]);
            if (!judge(t)) {
                System.out.println("false " + (i + 1));
                success = false;
                break;
            }
        }
        if (success) {
            System.out.println("true " + strs.length);
        }

    }

    private static boolean judge(int t) {
        if (t == 20) {
            if (count[1] >= 1 && count[0] >= 1) {
                count[1]--;
                count[0]--;
            } else if (count[0] >= 3) {
                    count[0] -= 3;
            } else {
                return false;
            }
        } else if (t == 10) {
            if (count[0] >= 1) {
                count[0]--;
            } else {
                return false;
            }
            count[1]++;
        } else {
            count[0]++;
        }

        return true;
    }
}
