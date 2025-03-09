package practice;

import java.util.HashMap;
import java.util.Map;

public class L1TwoSums {

    public static void main(String[] args) {
        int[] list = new int[]{3, 1, 2, 8, 4};
        int sum = 5;

        Map<Integer, Integer> hashSet = new HashMap<>();

        for (int i = 0; i < list.length; i++) {
            if (hashSet.containsKey(sum - list[i])) {
                System.out.println("Indices : " + hashSet.get(sum - list[i]) + ", " + i);
                return;
            }
            hashSet.put(list[i], i);
        }

    }
}
