package com.codejerry.京东;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Main3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        sc.nextLine();
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            String[] s = sc.nextLine().split(" ");
            if (s.length == 1) {
                for (int num : list) {
                    System.out.print(num + " ");
                }
                System.out.println();
            } else if (s.length == 2) {
                int index = Integer.parseInt(s[1]);
                list.remove(index - 1);
            } else {
                int index = Integer.parseInt(s[1]);
                int num = Integer.parseInt(s[2]);
                list.add(index - 1, num);
            }
        }
    }
}