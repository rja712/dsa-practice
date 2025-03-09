package practice;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class L523ContinuousSubarraySum {
    public static void main(String[] args) {
        int[] nums = new int[]{23, 2, 4, 6, 7};
        int k = 6;

        Map<Integer, Integer> firstRemainderIndex = new LinkedHashMap<>();
        Map<Integer, Integer> lastRemainderIndex = new LinkedHashMap<>();

        firstRemainderIndex.put(0, -1);
        lastRemainderIndex.put(0, -1);

        int prefixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            int remainder = prefixSum % k;

            firstRemainderIndex.putIfAbsent(remainder, i);
            lastRemainderIndex.put(remainder, i);
        }

        System.out.println(Arrays.toString(nums));

        int maxSubarraySize = -1;
        for (Integer remainder : firstRemainderIndex.keySet()) {
            if (firstRemainderIndex.get(remainder).equals(lastRemainderIndex.get(remainder))) {
                continue;
            }
            int currentSubarraySize = lastRemainderIndex.get(remainder) - firstRemainderIndex.get(remainder);
            System.out.print(remainder + ": (" + (firstRemainderIndex.get(remainder) + 1) + "," +
                    lastRemainderIndex.get(remainder) + ") => " + currentSubarraySize + "\n");

            if (currentSubarraySize > maxSubarraySize) {
                maxSubarraySize = currentSubarraySize;
            }
        }

        System.out.println(maxSubarraySize >= 2 ? "True" : "False");
    }
}