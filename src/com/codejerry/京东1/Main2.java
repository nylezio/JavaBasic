package com.codejerry.京东1;

import java.util.*;

/**
 * @author: codeJerry
 * @description:
 * @date: 2020/08/06 19:03
 */
public class Main2 {

    static Set<Integer> set = new HashSet<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int ans = 0;
        for (int i = n; i <= m; i++) {
            if (check(i)) {
                ans++;
            }
        }
        System.out.println(ans);


    }

    private static boolean check(int k) {
        String sb = Integer.toString(k);
        for (int i = 0; i < sb.length(); i++) {
            if (i > 0 && sb.charAt(i) == sb.charAt(i - 1)) {
                continue;
            }
            StringBuilder temp = new StringBuilder(sb.substring(0, i) + sb.substring(i + 1, sb.length()));
            int len = temp.length();
            if (len != 2 && len % 2 == 0) {
                return false;
            }
            int x = Integer.parseInt(temp.toString());
            if (set.contains(x)) {
                return true;
            }

            if (isPrime(x) && isPalindrome(temp)) {
                set.add(x);
                return true;
            }
        }
        return false;
    }

    private static boolean isPalindrome(StringBuilder temp) {
        int i = 0;
        int j = temp.length() - 1;

        while (i < j && temp.charAt(i) == '0') {
            i++;
        }
        while (i < j) {
            if (temp.charAt(i++) != temp.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrime(int N) {
        if (N < 2) {
            return false;
        }
        int R = (int) Math.sqrt(N);
        for (int d = 2; d <= R; ++d) {
            if (N % d == 0) {
                return false;
            }
        }
        return true;
    }


//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        System.out.println(countPrime(n, m));
//    }
//
//    public static int countPrime(int n, int m) {
//        int count = 0;
//        while (n <= m) {
//            Set<Integer> afterDelete = deleteDigit(n);
//            boolean flag = false;
//            for (int x : afterDelete) {
//                int len = numLength(x);
//                if (len != 2 && len % 2 == 0) {
//                    continue;
//                }
//                if (x == reverse(x) && isPrime(x)) {
//                    flag = true;
//                    break;
//                }
//            }
//            if (flag) count++;
//            n++;
//        }
//        return count;
//    }
//
//    public static boolean isPrime(int N) {
//        if (N < 2) return false;
//        int R = (int) Math.sqrt(N);
//        for (int d = 2; d <= R; ++d)
//            if (N % d == 0) return false;
//        return true;
//    }
//
//    public static int reverse(int N) {
//        int ans = 0;
//        while (N > 0) {
//            ans = 10 * ans + (N % 10);
//            N /= 10;
//        }
//        return ans;
//    }
//
//    public static int numLength(int num) {
//        int count = 0;
//        while (num >= 1) {
//            num /= 10;
//            count++;
//        }
//        return count;
//    }
//
//    public static Set<Integer> deleteDigit(int num) {
//        List<Integer> digits = new ArrayList<>();
//        while (num >= 1) {
//            int tmp = num % 10;
//            num /= 10;
//            digits.add(tmp);
//        }
//        Set<Integer> nums = new HashSet<>();
//        for (int i = 0; i < digits.size(); i++) {
//            int tmp = 0;
//            int count = 0;
//            for (int j = 0; j < digits.size(); j++) {
//                if (j != i) {
//                    tmp += digits.get(j) * ((int) Math.pow(10, count));
//                    count++;
//                }
//            }
//            nums.add(tmp);
//        }
//        return nums;
//    }
}
