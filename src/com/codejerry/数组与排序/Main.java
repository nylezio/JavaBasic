package com.codejerry.数组与排序;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: codeJerry
 * @description:
 * @date: 2020/09/01 10:50
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.findKthLargest(new int[]{7, 6, 5, 4, 3, 2, 1}, 5));
    }

    /**
     * 三数之和 = 0
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length <= 2) {
            return ans;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] + nums[i + 1] + nums[i + 2] > 0) {
                break;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum <= 0) {
                    if (sum == 0) {
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[k]);
                        ans.add(tmp);
                    }
                    j++;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                } else {
                    k--;
                    while (k > j && nums[k] == nums[k + 1]) {
                        k--;
                    }
                }
            }
        }
        return ans;
    }


    /**
     * 二分找旋转无重复的nums中的target
     */
    public int search(int[] nums, int target) {
        int n;
        if ((n = nums.length) == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int l = 0;
        int r = n;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] >= nums[0]) {
                if (nums[mid] > target && target >= nums[l]) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[r - 1]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }

        }
        return -1;
    }


    /**
     * 快排找第k大元素
     */
    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, nums.length - k);
    }

    public int quickSort(int[] nums, int l, int r, int index) {
        int partition = sort(nums, l, r);
        if (partition == index) {
            return nums[partition];
        }
        return partition > index ? quickSort(nums, l, partition - 1, index) : quickSort(nums, partition + 1, r, index);
    }

    public int sort(int[] nums, int l, int r) {
        if (l >= r) {
            return l;
        }
        int t = nums[l];
        int i = l;
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
        return j;
    }

    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }


    /**
     * 第K个排列
     * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
     * <p>
     * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
     * "123"
     * "132"
     * "213"
     * "231"
     * "312"
     * "321"
     * 给定 n 和 k，返回第 k 个排列。
     * 例123456，共有6！种排列方式
     * <p>
     * 具体来说：
     * 以1开头的，有5！种
     * 以2开头的，有5！种
     * 以3开头的，有5！种，
     * 。。。
     * 以此类推共6！种
     * 那么可以通过（k-1)/5!来判断结果中第一位是什么，得到第一位之后可以用同样的思路得到第2位。。
     * 即解题如下：
     * 以n=6，k=6！为例
     * 初始化一个初始的排序s=”123456“， ans=""，
     * （k-1)/5!=5，第一位是s[5]（即6）
     * 所以从s中删去6为“12345”， ans添加6为“6”，
     * 此时，情况变成了从新的s“12345”中找第k-5*5!个数
     * (k-5*5!-1)/4!=4，所以第二位是s[4]（即5）
     * ......
     * 以此类推，得到ans="654321"
     * 这样的话，时间复杂度应该是O(N*K)，空间复杂度是O(N)
     */

    public String getPermutation(int n, int k) {
        int[] fac = new int[n];
        fac[0] = 1;
        for (int i = 1; i < n; i++) {
            fac[i] = i * fac[i - 1];
        }
        List<Integer> bucket = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            bucket.add(i + 1);
        }

        k--;
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            int idx = k / fac[i];
            sb.append(bucket.get(idx));
            bucket.remove(idx);
            k -= idx * fac[i];
        }
        return sb.toString();
    }

    /**
     * 547 朋友圈
     * 并查集 union + find (使用路径压缩)
     */
    public int findCircleNum(int[][] M) {
        int n;
        if ((n = M.length) == 0) {
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
        } else {
            //并查集路径压缩
            parent[i] = find(parent, parent[i]);
            return parent[i];
        }

    }

    /**
     * 合并区间
     */
    public int[][] merge(int[][] intervals) {
        int n;
        if ((n = intervals.length) <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int start = intervals[0][0];
        int end = intervals[0][1];
        List<int[]> list = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] > end) {
                list.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            } else {
                end = Math.max(end, intervals[i][1]);
            }
            if (i == n - 1) {
                list.add(new int[]{start, end});
            }

        }
        int[][] ans = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            ans[i][0] = list.get(i)[0];
            ans[i][1] = list.get(i)[1];
        }
        return ans;
    }

    /**
     * 接雨水
     */
    public int trap(int[] height) {
        int n;
        if ((n = height.length) <= 1) {
            return 0;
        }
        int ans = 0;
        int leftMax = 0;
        int rightMax = 0;
        int i = 0;
        int j = n - 1;
        while (i < j) {
            if (height[i] <= height[j]) {
                if (height[i] < leftMax) {
                    ans += leftMax - height[i];
                } else {
                    leftMax = height[i];
                }
                i++;
            } else {
                if (height[j] < rightMax) {
                    ans += rightMax - height[j];
                } else {
                    rightMax = height[j];
                }
                j--;
            }
        }
        return ans;
    }


}

