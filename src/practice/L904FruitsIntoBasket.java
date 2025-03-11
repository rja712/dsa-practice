package practice;

import java.util.HashMap;

public class L904FruitsIntoBasket {

    public static void main(String[] args) {

        int[] fruits = new int[]{0, 1, 3, 2};
        int maxStreak = totalFruit(fruits);
        System.out.println("maxStreak: " + maxStreak);
    }

    public static int totalFruit(int[] fruits) {

        int left = 0;
        int right = 0;
        HashMap<Integer, Integer> fruitsCountMap = new HashMap<>();
        int maxStreak = 0;

        while (right < fruits.length) {
            fruitsCountMap.put(fruits[right], fruitsCountMap.getOrDefault(fruits[right], 0) + 1);

            if (fruitsCountMap.size() > 2) {
                fruitsCountMap.put(fruits[left], fruitsCountMap.get(fruits[left]) - 1);
                if (fruitsCountMap.get(fruits[left]) == 0) {
                    fruitsCountMap.remove(fruits[left]);
                }
                left++;
            }

            int streak = right - left + 1;
            maxStreak = Math.max(maxStreak, streak);


            right++;
        }
        return maxStreak;
    }
}
