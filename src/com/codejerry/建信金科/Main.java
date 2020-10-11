package com.codejerry.建信金科;

public class Main {
    public static void main(String[] args) {

    }

    public int findFriendNum(int[][] M) {
        int n;

        if ( (n = M.length) == 0) {
            return 0;
        }
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && M[i][j] == 1) {
                    union(parent, i, j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) {
                count++;
            }
        }
        return count;
    }

    public void union(int[] parent, int i, int j) {
        int x = find(parent, i);
        int y = find(parent, j);
        if (x != y) {
            parent[x] = y;
        }
    }

    public int find(int parent[], int i) {
        if (parent[i] == i) {
            return i;
        }
        else {
            //并查集路径压缩
            parent[i] = find(parent, parent[i]);
            return parent[i];
        }

    }
}
