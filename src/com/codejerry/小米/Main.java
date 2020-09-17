package com.codejerry.小米;

import java.util.*;


public class Main {

    static Map<Character, Character> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        while (sc.hasNext()) {
            System.out.println(check(sc.nextLine()));
        }

    }

    private static boolean check(String s) {
        char[] chs = s.toCharArray();
        if (chs.length == 0) {
            return true;
        }
        if (chs.length % 2 == 1) {
            return false;
        }
        Deque<Character> stack = new LinkedList<>();
        for (char ch : chs) {
            if (map.containsKey(ch)) {
                if (stack.isEmpty() || !stack.peek().equals(map.get(ch))) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
