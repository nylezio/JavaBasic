package com.codejerry.猿辅导;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: codeJerry
 * @description:
3
2 0
1 2
-1 2
 * 输出3
 * @date: 2020/08/01 18:54
 */
public class Main2 {
    public static void main(String[] args) {
        int mod = 1_000_000_003;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer>[] lists = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            lists[i] = new ArrayList<>();
        }

        int ans = 0;

        System.out.println(ans);


    }
}
