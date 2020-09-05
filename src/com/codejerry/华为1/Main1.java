package com.codejerry.华为1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: codeJerry
 * @description:
 * @date: 2020/08/19 19:27
 */
public class Main1 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] worker = new int[m][n];
        if (m < 10 || m > 1000 || n < 10 || n > 1000) {
            System.out.println("");
        } else {
            System.out.println(spiralOrder(worker));
        }

    }

    public static List<int[]> spiralOrder(int[][] matrix) {
        List<int[]> order = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        int rows = matrix.length, columns = matrix[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int total = rows * columns;
        int row = 0, column = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        for (int i = 1; i <= total; i++) {
            if (helper(i)) {
                order.add(new int[]{row, column});
            }
            visited[row][column] = true;
            int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]) {
                directionIndex = (directionIndex + 1) % 4;
            }
            row += directions[directionIndex][0];
            column += directions[directionIndex][1];
        }
        return order;
    }

    public static boolean helper(int num) {
        if (num % 10 == 7) {
            num /= 10;
            num %= 10;
            if (num % 2 == 1) {
                return true;
            }
        }
        return false;
    }
}