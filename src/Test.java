import java.util.*;

/**
 * @author: codeJerry
 * @description:
 * @date: 2020/09/08 10:01
 */
public class Test {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> map1 = new HashMap<>();
        map.put(1,1);
        map.put(2,6);
        map1.put(3,5);
        map1.put(0,5);
        map1.putAll(map);
        System.out.println(map.toString());
        System.out.println(map1.toString());

        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(4);
        Set<Integer> set = new HashSet<>(list);
        Set<Integer> set1 = new HashSet<>();
        set1.add(8);
        set1.add(9);
        set1.add(7);
        set.addAll(set1);
        System.out.println(set.containsAll(set1));
        System.out.println(set1.containsAll(set));
        System.out.println(set.toString());

    }
}

