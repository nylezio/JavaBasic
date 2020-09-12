package com.codejerry.远景;

import java.util.*;

//"I like apple!"
//I want to go to the zoo [ the small one
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] chs = sc.nextLine().toCharArray();
        System.out.println(check(chs));

    }

    public static boolean check(char[] chs) {
        Map<Character, Character> map = new HashMap<>();
//        map.put('"', '"');
        map.put('}', '{');
        map.put(']', '[');
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : chs) {
            if (ch == '"') {
                if (stack.isEmpty() || stack.peek() !=


                        '"') {
                    stack.push('"');
                } else {
                    stack.pop();
                }
            } else if (ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (map.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != map.get(ch)) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}
