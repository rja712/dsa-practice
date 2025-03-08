package practice;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {

        // Example array
        int[] list = new int[]{3, 1, 2, 8, 2};

        System.out.println("Before: " + Arrays.toString(list));

        int leftProduct = 1;
        int rightProduct = 1;

        int[] result = new int[list.length];

        // Compute left products
        for (int i = 0; i < list.length; i++) {
            result[i] = leftProduct; // Store product of all elements to the left
            leftProduct *= list[i];
        }

        // Compute right products and update result
        for (int i = list.length - 1; i >= 0; i--) {
            result[i] *= rightProduct; // Multiply with the product of all elements to the right
            rightProduct *= list[i];
        }

        System.out.println("Result: " + Arrays.toString(result));
    }
}