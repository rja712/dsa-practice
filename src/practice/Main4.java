package practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main4 {

    /*
    *
    * Given a string, find the length of the longest substring without repeating characters.
Example:
String str = "abcabcbb";
Answer : Length : 3 Substring : abc and bca and cab
    * */

    public static void main(String[] args) {


        String input = "abcabcbb";
        List<String> result = new ArrayList<>();

        if (input.length() <= 1) {
            System.out.println(1);
            return;
        }

        if (input.length() <= 2) {
            if (input.charAt(0) == input.charAt(1)) {
                System.out.println(1);
                return;
            } else {
                System.out.println(2);
                return;
            }
        }

        int left = 0;
        int right = 1;
        Set<Character> characterSet = new HashSet<>();
        characterSet.add(input.charAt(0));
        int maxsize = 0;


        while (left < right && right < input.length()) {

            if (characterSet.contains(input.charAt(right))) {
                left++;
            } else {
                characterSet.add(input.charAt(right));
                right++;
            }

            if (characterSet.size() > maxsize) {
                maxsize = characterSet.size();
            }


        }

        System.out.println(maxsize);


        for (String str : result) {
            System.out.println(str);
        }

    }
}
