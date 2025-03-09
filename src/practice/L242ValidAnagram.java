package practice;

public class L242ValidAnagram {
    public static void main(String[] args) {
        String s1 = "listen";
        String s2 = "silent";

        boolean result = isAnagram(s1, s2);

        System.out.println("Are \"" + s1 + "\" and \"" + s2 + "\" anagrams? " + result);
    }

    public static boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] charCount = new int[26]; // Fixed-size array for lowercase letters

        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a']++; // Increment count for s
            charCount[t.charAt(i) - 'a']--; // Decrement count for t
        }

        // Check if all values are zero
        for (int count : charCount) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}

