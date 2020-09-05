package com.codejerry.虾皮2;

import java.util.Scanner;

/**
 * @author: codeJerry
 * @description:
1.1.2,1.2
-1
0.01,0.001
0
1.0,1.0.0
0
 * @date: 2020/08/26 15:01
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String[] v = s.split(",");
        System.out.println(judge(v[0], v[1]));

    }

    public static int judge(String s1, String s2) {
        String[] v1 = s1.split("\\.");
        String[] v2 = s2.split("\\.");
        int n = v1.length;
        int m = v2.length;
        int index = 0;
        while (index < n || index < m) {
            int a = index < n ? Integer.parseInt(v1[index]) : 0;
            int b = index < m ? Integer.parseInt(v2[index]) : 0;
            if (a > b) {
                return 1;
            } else if (a < b) {
                return -1;
            } else {
                index++;
            }
        }
        return 0;
    }
}
