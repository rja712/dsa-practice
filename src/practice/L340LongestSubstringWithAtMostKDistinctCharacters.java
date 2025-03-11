package practice;

import java.util.HashMap;
import java.util.Map;

public class L340LongestSubstringWithAtMostKDistinctCharacters {

    public static void main(String[] args) {
        String s = "eceba";
        int k = 2;

        int left = 0;
        int right = 0; // Start from 0
        Map<Character, Integer> charCountMap = new HashMap<>();

        int largestSubString = 0;

        while (right < s.length()) {
            char rightChar = s.charAt(right);
            charCountMap.put(rightChar, charCountMap.getOrDefault(rightChar, 0) + 1);

            while (charCountMap.size() > k) {  // Shrink the window if distinct count > k
                char leftChar = s.charAt(left);
                charCountMap.put(leftChar, charCountMap.get(leftChar) - 1);
                if (charCountMap.get(leftChar) == 0) {
                    charCountMap.remove(leftChar);
                }
                left++;
            }

            largestSubString = Math.max(largestSubString, right - left + 1); // Update max length
            right++;
        }

        System.out.println("Largest substring length: " + largestSubString);
    }
}
