package practice;

import java.util.Arrays;
import java.util.Random;

public class L303RangeSum {


    public static int[] numArray(int[] nums) {
        int[] preSumArray = new int[nums.length];
        int preSumVal = 0;

        for (int i = 0; i < nums.length; i++) {
            preSumArray[i] = nums[i] + preSumVal;
            preSumVal = preSumVal + nums[i];
        }
        return preSumArray;
    }

    public static int sumRange(int[] preSumArray, int left, int right) {
        if (left == 0) {
            return preSumArray[right];
        }
        return preSumArray[right] - preSumArray[left - 1];

    }

    public static void main(String[] args) {
        int[] array = new Random().ints(5, 0, 10).toArray();
        System.out.println("Array: " + Arrays.toString(array));
        int[] preSumArray = numArray(array);
        System.out.println("PreSum: " + Arrays.toString(preSumArray));
        int val = sumRange(preSumArray, 2, 4);
        System.out.println("Val: " + val);
    }
}