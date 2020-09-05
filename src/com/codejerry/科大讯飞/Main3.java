package com.codejerry.科大讯飞;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x01 = sc.nextInt();
        int y01 = sc.nextInt();
        int x02 = sc.nextInt();
        int y02 = sc.nextInt();
        int x11 = sc.nextInt();
        int y11 = sc.nextInt();
        int x12 = sc.nextInt();
        int y12 = sc.nextInt();
        int zx = Math.abs(x01 + x02 - x11 - x12);
        int x = Math.abs(x01 - x02) + Math.abs(x11 - x12);
        int zy = Math.abs(y01 + y02 - y11 - y12);
        int y = Math.abs(y01 - y02) + Math.abs(y11 - y12);
        if (zx <= x && zy <= y) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

    }
}
