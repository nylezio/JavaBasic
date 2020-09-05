package com.codejerry.排序;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: codeJerry
 * @description:
 * @date: 2020/07/11 21:32
 */
public class Sort {

    public void scheduleCourse(int[][] courses) {

    }

    public static void main(String[] args) {
//        int[][] courses = new int[][]{
//            {100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}
//        };
//        Arrays.排序(courses, (a, b) -> a[0] - b[0]);
//        for (int i = 0; i < courses.length; i++) {
//            for (int j = 0; j < courses[0].length; j++) {
//                System.out.println(courses[i][j]);
//            }
//        }



        Map<Short, String> map = new HashMap<>();
        for(short i = 0; i <100; i++) {
            map.put(i, String.valueOf(i));
            map.remove(i-1);
        }
        System.out.println(map.size());
    }

}
