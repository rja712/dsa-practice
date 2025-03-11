package practice;

import java.util.HashMap;
import java.util.Map;

public class L424LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        int ret = characterReplacement("AABABBA", 1);
        System.out.println("Return: " + ret);
    }

    public static int characterReplacement(String s, int k) {
        int left = 0, maxFrequent = 0, maxLength = 0, li = -1, ri = -1;
        Map<Character, Integer> charCountMap = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            charCountMap.put(rightChar, charCountMap.getOrDefault(rightChar, 0) + 1);

            // Update maxFrequent using if-else instead of Math.max
            if (charCountMap.get(rightChar) > maxFrequent) {
                maxFrequent = charCountMap.get(rightChar);
            }

            // Check if the current window is invalid and shrink if necessary
            int currWindowSize = right - left + 1;
            if (currWindowSize - maxFrequent > k) {
                char leftChar = s.charAt(left);
                charCountMap.put(leftChar, charCountMap.get(leftChar) - 1);
                left++;  // Move left pointer to shrink window
            }

            // Update maxLength and indices
            if ((right - left + 1) > maxLength) {
                maxLength = right - left + 1;
                li = left;
                ri = right;
            }
        }

        System.out.println("Indexes: " + li + "," + ri);
        return maxLength;
    }
}