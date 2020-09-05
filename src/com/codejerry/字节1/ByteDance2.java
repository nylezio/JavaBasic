package com.codejerry.字节1;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: codeJerry
 * @description:
 * 括号匹配 {} [] ()
 * 括号的包含关系必须从大到小，大括号->中括号->小括号
 * @date: 2020/07/14 19:53
 */
public class ByteDance2 {

    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (stack.isEmpty() || !stack.pop().equals(map.get(c))) {
                    return false;
                }
            } else {
                if (!stack.isEmpty()) {
                    if (c == '{') {
                         if (stack.peek().equals('[') || stack.peek().equals('(')) {
                             return false;
                         }
                    }
                    if (c == '[' && stack.peek().equals('(')) {
                        return false;
                    }
                }
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "(){[[()]}[][()]()";
        ByteDance2 byteDance2 = new ByteDance2();
        System.out.println(byteDance2.isValid(s));
    }
}
