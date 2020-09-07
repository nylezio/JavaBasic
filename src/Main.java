import java.math.BigInteger;
import java.util.*;

/**
 * @author: codeJerry
 * @description:
 * @date: 2020/08/26 16:16
 */
public class Main {
    /**
     * 227基本计算器II
     *
     * @param s 字符串
     * @return 最终的值
     */
    public int calculate(String s) {
        String s1 = s.trim();
        char[] chs = s1.toCharArray();
        char type = '+';
        Deque<Integer> stack = new ArrayDeque<>();
        int cur = 0;
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == ' ') {
                continue;
            }
            if (Character.isDigit(chs[i])) {
                cur = cur * 10 + (chs[i] - '0');
            }
            if (i == chs.length - 1 || chs[i] == '+' || chs[i] == '-' || chs[i] == '*' || chs[i] == '/') {
                if (type == '+') {
                    stack.push(cur);
                } else if (type == '-') {
                    stack.push(-cur);
                } else if (type == '*') {
                    stack.push(stack.pop() * cur);
                } else {
                    stack.push(stack.pop() / cur);
                }
                cur = 0;
                type = chs[i];
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.poll();
        }
        return ans;
    }

    public static int gcb(int a, int b) {
        return a == 0 ? b : gcb(b % a, a);
    }


    public static int claim(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < i && j <= 6; j++) {
                dp[i] += dp[i - j];
            }
            if (i <= 6) {
                dp[i] += 1;
            }
        }
        return dp[n];
    }

    /**
     * 给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。
     * 找到并返回可以用这种方式转换的最短回文串。
     *
     * @param s "aacecaaa"
     * @return "aaacecaaa"
     */
    public String shortestPalindrome(String s) {

        int n = s.length();
        int[] fail = new int[n];
        Arrays.fill(fail, -1);
        for (int i = 1; i < n; ++i) {
            int j = fail[i - 1];
            while (j != -1 && s.charAt(j + 1) != s.charAt(i)) {
                j = fail[j];
            }
            if (s.charAt(j + 1) == s.charAt(i)) {
                fail[i] = j + 1;
            }
        }
        System.out.println(Arrays.toString(fail));
        int best = -1;
        for (int i = n - 1; i >= 0; i--) {
            while (best != -1 && s.charAt(best + 1) != s.charAt(i)) {
                best = fail[best];
            }
            if (s.charAt(best + 1) == s.charAt(i)) {
                best++;
            }
            System.out.println(best);
        }

        StringBuilder need = new StringBuilder(best == n - 1 ? "" : s.substring(best + 1, n));
        need.reverse().append(s);
        return need.toString();
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String[] strs = s.split(",");
        int[] nums = new int[strs.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                ans.add(Math.abs(nums[i]));
            }
            nums[index] = -nums[index];
        }
        for (Integer an : ans) {
            System.out.print(an);
            System.out.print(" ");
        }
    }


}
