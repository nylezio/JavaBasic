import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

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




    public static void main(String[] args) {

    }

}
