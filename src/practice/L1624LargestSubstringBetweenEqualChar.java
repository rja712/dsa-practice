package practice;

import java.util.HashMap;
import java.util.Map;

public class L1624LargestSubstringBetweenEqualChar {

    public static void main(String[] args) {
        String str = "pooookie";
        Map<Character, Integer> hashSet = new HashMap<>();
        int largestSubstringSize = -1;
        for (int i = 0; i < str.length(); i++) {
            if (hashSet.containsKey(str.charAt(i))) {
                int currSubstringSize = i - hashSet.get(str.charAt(i)) - 1;
                if (currSubstringSize > largestSubstringSize) {
                    largestSubstringSize = currSubstringSize;
                }
            }
            hashSet.put(str.charAt(i), i);
        }
        System.out.println("LargestSubstringSize: " + largestSubstringSize);

    }
}
