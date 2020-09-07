package com.codejerry.搜狗;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(numberofprize(8, 5, 0));
    }

    public static int numberofprize(int a, int b, int c) {
        // write code here

        int min = Math.min(a, Math.min(b, c));
        int max = Math.max(a, Math.max(b, c));
        int mid = a - min + b - max + c;
        int ans = min;
        max -= ans;
        mid -= ans;
        ans += count(max, mid);
        return ans;
    }

    private static int count(int a, int b) {
        int m = Math.min(b, (a - b) / 2);
        a -= 3 * m;
        b -= m;
        if (b == 0) {
            return m + a / 5;
        } else {
            return m + b / 2;
        }
    }

    class Room {
        float start;
        float end;

        public Room(float start, float emd) {
            this.start = start;
            this.end = emd;
        }
    }

    public int getHouses(int t, int[] xa) {
        // write code here
        List<Room> roomList = new ArrayList<>();
        List<Float> width = new ArrayList<>();
        int i = 0;
        while (i < xa.length) {
            int center = xa[i];
            i++;
            int range = xa[i];
            i++;
            float half = ((float) range) / 2;
            roomList.add(new Room(center - half, center + half));
        }
        for (i = 1; i < roomList.size(); i++) {
            Room room = roomList.get(i);
            Room pre = roomList.get(i - 1);
            width.add(room.start - pre.end);
        }
        int res = 2;
        for (float w : width) {
            if (w == t) {
                res += 1;
            } else if (w > t) {
                res += 2;
            }
        }
        return res;
    }


    public long getPasswordCount(String password) {
        // write code here
        int[] nums = new int[password.length()];
        for (int i = 0; i < password.length(); i++) {
            nums[i] = password.charAt(i) - '0';
        }
        long res = 0;
        for (int i = 0; i <= 9; i++) {
            res += coun_t(nums, i, 1, nums[0] == i);
        }
        return res;
    }

    private long coun_t(int[] nums, int cur, int start, boolean isAll) {
        if (start >= nums.length) {
            return isAll ? 0 : 1;
        }
        int sum = cur + nums[start];
        if (sum % 2 == 0) {
            isAll = sum / 2 == nums[start] && isAll;
            return coun_t(nums, sum / 2, start + 1, isAll);
        } else {
            int a = (int) Math.ceil(((double) sum / 2));
            int b = (int) Math.floor(((double) sum / 2));
            return coun_t(nums, (int) Math.ceil(((double) sum / 2)), start + 1, a == nums[start] && isAll) +
                    coun_t(nums, (int) Math.floor(((double) sum / 2)), start + 1, b == nums[start] && isAll);

        }
    }
}
