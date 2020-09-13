package com.codejerry.网易2;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int ans = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        List<TreeNode> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            list.add(new TreeNode());
        }
        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            String dir = sc.next();
            int nextId = sc.nextInt();
            if ("left".equals(dir)) {
                list.get(id - 1).left = list.get(nextId - 1);
            } else {
                list.get(id - 1).right = list.get(nextId - 1);
            }
        }
        dfs(list.get(0));
        System.out.println(ans);
    }

    private static void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            return;
        }
        TreeNode left = node.left;
        TreeNode right = node.right;
        if (left != null && right != null) {
            if (left.left == null && left.right == null && right.left == null && right.right == null) {
                ans++;
            }
        }

        dfs(left);
        dfs(right);
    }
}

class TreeNode {
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }
}
