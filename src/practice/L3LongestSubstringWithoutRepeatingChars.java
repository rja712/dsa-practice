package practice;

import java.util.HashSet;
import java.util.Set;

public class L3LongestSubstringWithoutRepeatingChars {

    public static void main(String[] args) {

        String s = "qrsvbspk";
        int val = lengthOfLongestSubstring(s);
        System.out.println(s + ": " + val);

    }

    public static int lengthOfLongestSubstring(String s) {

        if (s.length() < 2) {
            return s.length();
        }

        int left = 0;
        int right = 1;

        Set<Character> characterSet = new HashSet<>();
        characterSet.add(s.charAt(0));
        int size = 0;

        while (right < s.length()) {
            if (characterSet.contains(s.charAt(right))) {
                characterSet.remove(s.charAt(left));
                left++;
            } else {
                characterSet.add(s.charAt(right));
                right++;
            }
            if (characterSet.size() > size) {
                size = characterSet.size();
                System.out.println("Index: " + left + "," + right);
            }
        }


        return size;

    }
}
