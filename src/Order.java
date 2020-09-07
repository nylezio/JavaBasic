import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: codeJerry
 * @description:
 * @date: 2020/08/16 16:12
 */
public class Order {
    public static void main(String[] args) {
//        TreeNode node = new TreeNode(1);
//        node.left = new TreeNode(2);
//        node.right = new TreeNode(3);
//        inorder(node);
//        preorder(node);
//        postorder(node);
    }


    public static void inorder(TreeNode head) {
        if (head == null) {
            return;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = head;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            System.out.println(cur.val);
            cur = cur.right;
        }
    }

    public static void preorder(TreeNode head) {
        if (head == null) {
            return;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = head;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                System.out.println(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
    }

    public static void postorder(TreeNode head) {
        if (head == null) {
            return;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = head;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode t = stack.peek();
            if (t.right == null) {
                stack.pop();
                System.out.println(t.val);
            } else {
                cur = t.right;
                t.right = null;
            }

        }
    }
}

abstract class TreeNode {
    final int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
