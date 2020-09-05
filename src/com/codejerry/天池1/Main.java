package com.codejerry.天池1;

/**
 * @author: codeJerry
 * @description:
 * @date: 2020/08/16 10:03
 */
public class Main {
    public static void main(String[] args) {
//        String s = "abcdefghi";
//        int[] su = new int[]{3,2,2,1,1};
//        System.out.println(reformatString(s, su));
//        double[] pos = new double[]{0, 0, 2.5, 3, 2, 0.5, 0, 2};
//        System.out.println(IfIntersect(pos));
        System.out.println(minDays(82129117));
    }

    public static String reformatString(String str, int[] sublen) {
        //
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int cur = 0;
        while (i < sublen.length) {
            if (i + 1 < sublen.length) {
                int nextB = cur + sublen[i];
                int nextE = nextB + sublen[i + 1];
                StringBuilder t = new StringBuilder(str.substring(nextB, nextE));
                t.append(str, cur, nextB);
                sb.append(t);
                cur = nextE;
                i = i + 2;
            } else {
                sb.append(str, cur, str.length());
                i++;
            }
        }
        return sb.toString();
    }

    public static int IfIntersect(double[] position) {
        // write your code here
        int ans = -1;
        double x0 = position[0];
        double y0 = position[1];
        double r1 = position[2];
        double x1 = position[3];
        double y1 = position[4];
        double r2 = position[5];
        double x2 = position[6];
        double y2 = position[7];

        if (pointToSegDist(x0,y0,x1,y1, x2,y2) <= r1 + r2) {
            return 1;
        }

        return -1;
    }

    private static double pointToSegDist(double x0, double y0, double x1, double y1, double x2, double y2) {
        double ans = 0;
        double a, b, c;
        a = distance(x0, y0,x1,y1);
        b = distance(x0, y0, x2, y2);
        c = distance(x1, y1, x2, y2);
        if (c+b==a) {//点在线段上
            ans = 0;
            return ans;
        }
        if (a<=0.00001) {//不是线段，是一个点
            ans = b;
            return ans;
        }
        if (c*c >= a*a + b*b) { //组成直角三角形或钝角三角形，p1为直角或钝角
            ans = b;
            return ans;
        }
        if (b * b >= a * a + c * c) {// 组成直角三角形或钝角三角形，p2为直角或钝角
            ans = c;
            return ans;
        }
        // 组成锐角三角形，则求三角形的高
        double p0 = (a + b + c) / 2;// 半周长
        double s = Math.sqrt(p0 * (p0 - a) * (p0 - b) * (p0 - c));// 海伦公式求面积
        ans = 2*s / a;// 返回点到线的距离（利用三角形面积公式求高）
        return ans;
    }

    private static double distance(double x, double y, double x1, double y1) {
        double dis = Math.pow((Math.pow(x - x1, 2) + Math.pow(y - y1, 2)), 0.5);
        return dis;
    }




    public static long doingHomework(int[] cost, int[] val) {
        // Write your code here.
        int[] sum = new int[cost.length + 1];
        sum[0] = 0;
        for (int i = 1; i <= cost.length; i++) {
            sum[i] = sum[i - 1] + cost[i - 1];
        }
        long ans = 0;
        for (int j : val) {
            ans += getTime(sum, j);
        }
        return ans;
    }

    private static long getTime(int[] sum, int val) {
        long t = 0;
        int i = 0;
        int j = sum.length - 1;
        while (i <= j) {
            int mid = i + ((j - i) >> 1);
            if (sum[mid] == val) {
                return val;
            } else  if (sum[mid] < val) {
                i = mid + 1;
            } else  {
                j = mid - 1;
            }
        }
        return sum[j];
    }

    public static  int minDays(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {

            dp[i] = dp[i - 1] + 1;
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            if (i % 3 == 0) {

                dp[i] = Math.min(dp[i], dp[i - 2 * (i / 3)] + 1);
            }
        }

        return dp[n];
    }
}
