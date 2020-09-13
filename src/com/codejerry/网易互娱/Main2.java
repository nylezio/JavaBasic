package com.codejerry.网易互娱;

public class Main2 {
    public static void main(String[] args) {
        String s =
                "BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBeeeeeeeeeeFYHHnjHAPQQc";
        System.out.println(compress(s));
    }

    public static String compress (String raw_str) {
        // write code here
        int n;
        if (raw_str == null || (n = raw_str.length()) == 0) {
            return raw_str;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 1;
        while (j < n) {
            while (j < n && raw_str.charAt(j) == raw_str.charAt(i)) {
                j++;
            }
            sb.append( change(raw_str.substring(i, j)) );
            i = j;
            j = i;

        }
        return sb.toString();
    }

    private static String change(String s) {
        if (s.length() < 4) {
            return s;
        } else if (s.length() <= 55) {
            char c = 'a';
            if (s.length() <= 29) {
                c += s.length() - 4;
            } else {
                c += 'A' - 'a' + s.length() - 30;
            }
            return "0" + c + s.charAt(0);
        } else {

            return change(s.substring(0, 55)) + change(s.substring(55, s.length()));
        }

    }
}
