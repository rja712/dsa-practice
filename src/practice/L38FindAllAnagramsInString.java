package practice;

import java.util.*;

public class L38FindAllAnagramsInString {
    public static void main(String[] args) {


        List<Integer> result = findAnagrams("cbaebabacd", "abc");

        System.out.println(result);
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> indexList = new ArrayList<>();

        if (p.length() > s.length()) {
            return indexList;
        }


        int[] pBitMap = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pBitMap[p.charAt(i) - 'a']++;
        }

        int[] sBitMap = new int[26];
        for (int i = 0; i < p.length(); i++) {
            sBitMap[s.charAt(i) - 'a']++;
        }

        if (Arrays.equals(pBitMap, sBitMap)) {
            indexList.add(0);
        }

        for (int i = p.length(); i < s.length(); i++) {

            sBitMap[s.charAt(i) - 'a']++;
            sBitMap[s.charAt(i - p.length()) - 'a']--;

            if (Arrays.equals(pBitMap, sBitMap)) {
                indexList.add(i - p.length() + 1);
            }


        }

        return indexList;


    }

}

