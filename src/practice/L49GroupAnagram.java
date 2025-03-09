package practice;

import java.util.*;

public class L49GroupAnagram {
    public static void main(String[] args) {
        String[] words = {"bdddddddddd", "bbbbbbbbbbc"};

        List<List<String>> result = groupAnagrams(words);

        System.out.println(result);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> bitMapVsStringMap = new LinkedHashMap<>();
        for (String str : strs) {
            String bitMap = prepareBitMap(str);
            if (bitMapVsStringMap.containsKey(bitMap)) {
                bitMapVsStringMap.get(bitMap).add(str);
            } else {
                bitMapVsStringMap.put(bitMap, new ArrayList<>(List.of(str)));
            }
        }
        System.out.println(bitMapVsStringMap);
        return bitMapVsStringMap.values().stream().toList();
    }

    private static String prepareBitMap(String str) {
        int[] bitMap = new int[26];
        for (int i = 0; i < str.length(); i++) {
            bitMap[str.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int bit : bitMap) {
            sb.append(bit).append(',');
        }
        return sb.toString();

    }
}

