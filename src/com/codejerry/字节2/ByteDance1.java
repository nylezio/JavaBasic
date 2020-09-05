package com.codejerry.字节2;

/**
 * @author: codeJerry
 * @description:
 *
 * 1,3,5,7,9,11,13,8,1
 * @date: 2020/07/14 19:26
 */
public class ByteDance1 {
    public static int binSearch(int[] src) {
        int ans = src.length;
        int i = 0;
        int j = ans - 1;
        while (i <= j) {
            int mid = i + ((j - i) >> 1);
            if (src[mid] < src[mid + 1] ) {
                ans = mid;
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] src = {1,3,5,7,9,11,8,1};
        System.out.println(binSearch(src));
    }
}
