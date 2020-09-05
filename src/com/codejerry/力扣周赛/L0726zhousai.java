package com.codejerry.力扣周赛;



import java.util.*;

/**
 * @author: codeJerry
 * @description:
 * @date: 2020/07/23 20:01
 */
public class L0726zhousai {


    public String restoreString(String s, int[] indices) {
        StringBuilder sb = new StringBuilder(s);
        char[] chars = s.toCharArray();
        int index = 0;
        for (int value : indices) {
            sb.setCharAt(value, chars[index++]);
        }
        return sb.toString();
    }

    public int minFlips(String target) {
        int ans = 0;
        char[] chars = target.toCharArray();
        int index = target.length() - 1;
        boolean has = false;
        while (index >= 0) {
            if (chars[index] == '0') {
                has = true;
            }
            while (index >= 0 && chars[index] == '0') {
                index--;
            }
            if (index < 0) {
                break;
            }
            if (chars[index] == '1') {
                while (index >= 0 && chars[index] == '1') {
                    index--;
                }
                if (has) {
                    ans += 2;
                } else {
                    ans += 1;
                }
            }
        }
        return ans;
    }

    int ans;
    int distance;
    public int countPairs(TreeNode root, int distance) {
        ans = 0;
        this.distance = distance;
        dfs(root);
        return ans;
    }

    private Map<Integer, Integer> dfs(TreeNode root) {
        if (root == null) {
            return new TreeMap<>();
        }
        Map<Integer, Integer> map = new TreeMap<>((a, b) -> b - a);
        if (root.left == null && root.right == null) {
            map.put(0, 1);
            return map;
        }

        Map<Integer, Integer> left = dfs(root.left);
        Map<Integer, Integer> right = dfs(root.right);
        for (Integer i: left.keySet()
        ) {
            for (Integer j: right.keySet()
            ) {
                if (i >= distance - 1) {
                    continue;
                }
                if (j >= distance - 1) {
                    continue;
                }
                if (i + j + 2 <= distance) {
                    ans += left.get(i) * right.get(j);
                }
            }
        }
        for (Integer i: left.keySet()
        ) {
            int val = left.get(i);
            int key = i + 1;
            int ori = map.getOrDefault(key, 0);
            map.put(key, val + ori);
        }
        for (Integer i: right.keySet()
        ) {
            int val = right.get(i);
            int key = i + 1;

            int ori = map.getOrDefault(key, 0);
            map.put(key, val + ori);
        }

        return  map;

    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
