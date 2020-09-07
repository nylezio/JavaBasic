package com.codejerry.腾讯1;

import java.util.*;

/**
 4 2
 1
 1
 2
 3
 输出
 1 2
 2 1
 2 1
 3 1
 输入
 4 2
 1
 2
 3
 4
 输出
 1 1
 2 1
 1 1
 2 1

 */
public class Main {
    static Map<String, Integer> map = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        PriorityQueue<String> queMax = new PriorityQueue<>(k, (a, b) -> map.get(a).equals( map.get(b) ) ? a.compareTo(b) : map.get(b) - map.get(a));
        PriorityQueue<String> queMin = new PriorityQueue<>(k, (a, b) -> map.get(a).equals( map.get(b) ) ? a.compareTo(b) : map.get(a) - map.get(b));

        for (String s : map.keySet()) {
            queMax.offer(s);
            queMin.offer(s);
        }
        printQue(queMax, k);
        printQue(queMin, k);
    }

    private static void printQue(PriorityQueue<String> que, int k) {
        for (int i = 0; i < k; i++) {
            String s = que.poll();
            System.out.print(s);
            System.out.print(" ");
            System.out.print(map.get(s));
            System.out.println();
        }
    }




}