package com.codejerry.科大讯飞;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        for (int i = 0; i < s.length(); i++) {

            if (Character.isDigit(s.charAt(i)) || s.charAt(i) == '-') {
                System.out.print(s.charAt(i));
            }
        }

    }
}
