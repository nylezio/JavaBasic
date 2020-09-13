package com.codejerry.爱奇艺;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: codeJerry
 * @description:(100)
 * @date: 2020/09/13 15:00
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int candidate = 0;
        int count = 0;
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        while (sc.hasNext()) {
            int t = sc.nextInt();
            list.add(t);
            if (t == candidate) {
                count++;
            } else {
                count--;
                if (count < 0) {
                    candidate = t;
                    count = 1;
                }
            }
            sum++;
        }
        count = 0;
        for (int l : list) {
            if (l == candidate) {
                count++;
            }
        }
        if (count >= sum / 2) {
            System.out.println(candidate);
        } else {
            System.out.println(-1);
        }
    }

}
