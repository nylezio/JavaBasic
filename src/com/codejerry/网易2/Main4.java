package com.codejerry.网易2;


import java.util.*;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] man = sc.nextLine().split(" ");
        Set<Integer> set_of_man = new HashSet<>();
        for (String m : man) {
            set_of_man.add(Integer.parseInt(m));
        }
        String[] women = sc.nextLine().split(" ");
        Set<Integer> set_of_women = new HashSet<>();
        for (String w : women) {
            set_of_women.add(Integer.parseInt(w));
        }

        int n = Integer.parseInt(sc.nextLine());
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] s = sc.nextLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            if (!map.containsKey(a)) {
                map.put(a, new HashSet<>());
            }
            map.get(a).add(b);
        }

        System.out.println(dfs(map, set_of_man, set_of_women));
    }

    private static int dfs(Map<Integer, Set<Integer>> map, Set<Integer> set_of_man, Set<Integer> set_of_women) {
        if (set_of_man.size() == 0 || set_of_women.size() == 0) {
            return 0;
        }
        int res = 0;

        for (int m : map.keySet()) {
            Set<Integer> set = map.get(m);
            for (int w : set) {
                if (set_of_man.contains(m) && set_of_women.contains(w)) {
                    set_of_man.remove(m);
//                    map.remove(m);
                    set_of_women.remove(w);
                    int t = dfs(map, set_of_man, set_of_women) + 1;
                    res = Math.max(res, t);
//                    map.put(m, set);
                    set_of_man.add(m);
                    set_of_women.add(w);
                }
            }
        }
        return res;

    }
}
