package com.codejerry.链表与树;


import java.util.*;

/**
 * @author: codeJerry
 * @description:
 * @date: 2020/09/02 16:54
 */
public class Main {
    public static void main(String[] args) {

        int[][] arrs = new int[][]{
                {100, 5, 3}, {50, 3, 2}, {300, 3, 3}
        };
        int n = 3;
        int w = 10;
        int money = 1000;
        Arrays.sort(arrs, (a, b) -> (a[2] == b[2] ? a[0] - b[0] : b[2] - a[2]));
        for (int[] a : arrs) {
            System.out.println(Arrays.toString(a));
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (w >= arrs[i][1] && money >= arrs[i][0]) {
                w -= arrs[i][1];
                money -= arrs[i][0];
                count++;
            } else {
                break;
            }
        }
        System.out.println(count);

        int[][] nums = new int[][]{
                {1, 2, 4}, {1, 3, 1}, {1, 2, 1}
        };
        int[][] dp = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + Math.abs(nums[i][j] - nums[i][j - 1]);
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + Math.abs(nums[i][j] - nums[i - 1][j]);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + Math.abs(nums[i][j] - nums[i - 1][j]),
                            dp[i][j - 1] + Math.abs(nums[i][j] - nums[i][j - 1]));
                }

            }
        }
        System.out.println(dp[2][2]);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA, b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return mergeKLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeKLists(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        int mid = l + ((r - l) >> 1);
        ListNode left = mergeKLists(lists, l, mid);
        ListNode right = mergeKLists(lists, mid + 1, r);
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        if (left.val <= right.val) {
            left.next = merge(left.next, right);
            return left;
        } else {
            right.next = merge(left, right.next);
            return right;
        }
    }

    /**
     * 递归的
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        if (l == null) {
            return r;
        }
        if (r == null) {
            return l;
        }
        return root;
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        Map<TreeNode, TreeNode> map = new HashMap<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while (!que.isEmpty() || !(map.containsKey(p) && map.containsKey(q))) {
            TreeNode node = que.poll();
            if (node.left != null) {
                que.add(node.left);
                map.put(node.left, node);
            }
            if (node.right != null) {
                que.add(node.right);
                map.put(node.right, node);
            }

        }
        Set<TreeNode> set = new HashSet<>();

        while (map.containsKey(p)) {
            set.add(p);
            p = map.get(p);
        }
        while (map.containsKey(q)) {
            if (set.contains(q)) {
                return q;
            }
            q = map.get(q);

        }
        return root;
    }


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()) {
            int len = que.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = len - 1; i >= 0; i--) {
                TreeNode node = que.poll();
                tmp.add(node.val);
                if (node.left != null) {
                    que.offer(node.left);
                }
                if (node.right != null) {
                    que.offer(node.right);
                }
            }
            if (ans.size() % 2 == 1){
                Collections.reverse(tmp);

            }
            ans.add(tmp);
        }
        return  ans;

    }

    public int maximalSquare(char[][] matrix) {
        int n, m;
        if ((n = matrix.length) == 0 || (m = matrix[0].length) == 0) {
            return 0;
        }
        int ans = 0;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;

                    }

                }
                ans = Math.max(ans, dp[i][j] * dp[i][j]);
            }
        }
        return ans;
    }


    public int maxSubArray(int[] nums) {
        int n;
        if ((n = nums.length) == 0) {
            return 0;
        }
        int ans = Integer.MIN_VALUE;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[i] = nums[i];
            } else {
                if (dp[i - 1] > 0) {
                    dp[i] = dp[i - 1] + nums[i];
                } else {
                    dp[i] = nums[i];
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    /**
     * 俄罗斯套娃，高度宽度有重复
     */
    public static int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0) {
            return 0;
        }
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for (int i = 1; i < envelopes.length; i++) {

            if (envelopes[i][1] > envelopes[list.get(list.size() - 1)][1]) {
                list.add(i);
            } else {
                int l = 0;
                int r = list.size() - 1;
                while (l <= r) {
                    int mid = l + ((r - l) >> 1);
                    if (envelopes[i][1] > envelopes[list.get(mid)][1]) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                list.set(l, i);
            }
        }

        return list.size();
    }
}
