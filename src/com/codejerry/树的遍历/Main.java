package com.codejerry.树的遍历;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {

    }

    public String preorderTraversal(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            return "";
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                sb.append(cur.val);
                sb.append(",");
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }
}
