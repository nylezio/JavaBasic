import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

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


    public static void main(String[] args) throws Exception {
        int[] nums = new int[]{5,3,8,2,6};
        quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static float stringToFloat(String s) throws Exception {
        if (s == null || s.length() == 0) {
            throw new Exception("字符串是空");
        }

        String[] strs = s.trim().split("\\.");
        if (strs.length > 2) {
            throw new Exception("输入无效字符串");
        }

        int sign = 1;
        int i = 0;
        char firstChar;
        if ((firstChar = strs[0].charAt(0)) == '-') {
            sign = -1;
            i = 1;
        } else if (firstChar == '+') {
            i = 1;
        } else if (!Character.isDigit(firstChar)) {
            throw new Exception("输入无效字符串");
        }
        float ans = 0;
        while (i < strs[0].length()) {
            if (Character.isDigit(strs[0].charAt(i))) {
                ans = ans * 10 + (strs[0].charAt(i) - '0');
                i++;
            } else {
                throw new Exception("输入无效字符串");
            }
        }
        if (strs.length == 2) {
            float tmp = 0;
            float t = (float) 0.1;
            int j = 0;
            while (j < strs[1].length()) {
                if (Character.isDigit(strs[1].charAt(j))) {
                    tmp += t * (strs[1].charAt(j) - '0');
                    t *= 0.1;
                    j++;
                } else {
                    throw new Exception("输入无效字符串");
                }
            }
            ans += tmp;
        }

        return sign * ans;


    }

    public static void quickSort(int[] nums) {
        int n;
        if ((n = nums.length) == 0) {
            return;
        }
        quickSort(nums, 0, n - 1);
    }

    public static void quickSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int t = nums[l];
        int i = l + 1;
        int j = r;
        while (true) {
            while (i < r && nums[i] <= t) {
                i++;
            }
            while (j > l && nums[j] >= t) {
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, l, j);
        quickSort(nums, l, j - 1);
        quickSort(nums, j + 1, r);
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }



    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            int tar = i + nums[i];
            for (int j = i + 1; j <= tar && j < n; j++) {
                dp[j] = dp[j] == -1 ? dp[i] + 1 : Math.min(dp[j], dp[i] + 1);
            }
        }
        return dp[n - 1];
    }


}



