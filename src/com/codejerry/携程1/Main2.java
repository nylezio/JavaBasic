package com.codejerry.携程1;

import java.util.*;

//a bc d eag f
public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(" ");
        dfs(strs, 0, new StringBuilder(), new HashMap<Character, Integer>());

    }

    private static void dfs(String[] strs, int index, StringBuilder sb, Map<Character, Integer> map) {
        if (index == strs.length) {
            System.out.print(sb.toString());
            boolean flag = true;
            for (char c : map.keySet()) {
                if (map.get(c) > 1) {
                    flag = false;
                }
            }
            if (!flag) {
                System.out.print("--circular dependency");
            }
            System.out.println();
            return;
        }
        char[] chs = strs[index].toCharArray();
        for (char ch : chs) {
            sb.append(ch);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            dfs(strs, index + 1, sb, map);
            sb.deleteCharAt(sb.length() - 1);
            map.put(ch, map.get(ch) - 1);
        }
    }

}
