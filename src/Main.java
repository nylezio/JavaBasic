import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.*;
import java.util.stream.Collectors;

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


    public static void main(String[] args) throws Exception {
        System.out.println(stringToFloat("-10.12340112"));

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> result = list.stream().filter((value) -> value > 2).collect(Collectors.toList());
        result.forEach((value) -> System.out.print(value + " "));
        System.out.println();
        System.out.println(list.stream().max((a,b)->(a - b)).get());
        System.out.println(list.stream().min((a,b)->(a - b)).get());
        System.out.println(list.stream().reduce(Integer::sum).get());
        getMethods();
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

    /**
     * 动态生成类的字节码,并打印动态类的每个方法
     */
    public static void getMethods(){
        //动态生成代理类
        Class clazzProxy1 = Proxy.getProxyClass(Collection.class.getClassLoader(), Collection.class);

        //获取这个代理类的构造方法
        Method[] methods = clazzProxy1.getMethods();

        System.out.println("---------------------begin Construstors-----------------");
        //遍历构造方法
        for (Method method: methods) {
            //获取每个名称
            String name = method.getName();
            StringBuilder sb = new StringBuilder(name);
            sb.append("(");
            //获取每个构造方法的参数类型
            Class[] clazzTypes = method.getParameterTypes();
            for (Class clazzType : clazzTypes) {
                sb.append(clazzType.getName()).append(".");
            }
            if(clazzTypes != null && clazzTypes.length != 0){
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append(")");
            System.out.println(sb.toString());
        }
    }
}

