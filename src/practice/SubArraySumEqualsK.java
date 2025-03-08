package practice;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class SubArraySumEqualsK {

    public static void main(String[] args) {

        // Example array
        int[] list = new int[]{0, 3, 0, 1, 2, 8, 2};
        int k = 3;
        int count = 0;

        System.out.println("Before: " + Arrays.toString(list));

        Map<Integer, Integer> prefixSumCount = new LinkedHashMap<>();
        prefixSumCount.put(0, 1);

        int prefixSum = 0;
        for (int i = 0; i < list.length; i++) {
            prefixSum = prefixSum + list[i];

            if (prefixSumCount.containsKey(prefixSum - k)) {
                count += prefixSumCount.get(prefixSum - k); // Add its frequency to count
            }

            prefixSumCount.put(prefixSum, prefixSumCount.getOrDefault(prefixSum, 0) + 1);

        }

        prefixSumCount.forEach((key, value) ->
                System.out.println("Sum = " + key + " -> Count = " + value)
        );

        System.out.println("Count= " + count);
    }


}
