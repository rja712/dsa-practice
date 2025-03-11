package practice;

public class L634MaxAvgSubArray {

    public static void main(String[] args) {

        int[] arr = {1, 1, 1, 2, -5, -6, 50, 3};

        double avg = findMaxAverage(arr, 3);
        System.out.println("avg :" + avg);

    }

    public static double findMaxAverage(int[] nums, int k) {

        double sum = 0;

        for (int i = 0; i < k; i++) {
            sum = sum + nums[i];
        }


        int left = 0;
        int right = k;

        double maxSum = sum;

        while (right < nums.length) {

            sum = sum - nums[left];
            sum = sum + nums[right];

            maxSum = Math.max(maxSum, sum);

            left++;
            right++;
        }

        return maxSum / k;

    }
}
