package practice;

import java.util.ArrayList;
import java.util.List;

public class L131PalindromePartitioning {

    public static void main(String[] args) {
        for (List<String> partitionList : getPalindromePartitionLists("aab")) {
            System.out.println(partitionList);
        }
    }

    public static List<List<String>> getPalindromePartitionLists(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, new ArrayList<>(), "", 0, result);
        return result;
    }


    private static void backtrack(String input, List<String> currPartitionList, String currString, int index, List<List<String>> result) {

        if (index == input.length()) {
            result.add(new ArrayList<>(currPartitionList));
            return;
        }

        boolean isPalindrome = currString.equals(new StringBuilder(currString).reverse().toString());

        if (isPalindrome){
            currPartitionList.add(currString);
        }






    }
}
