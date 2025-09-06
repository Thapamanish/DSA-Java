package arrays.medium;

import java.util.Arrays;

public class MaxSubarraySumPrint {

    /**
     * Brute Force Approach
     * This method checks every possible subarray, calculates its sum, and keeps
     * track of the maximum sum found so far, along with the start and end
     * indices of that subarray.
     * Time: O(N^2) - Two nested loops.
     * Space: O(1) - No extra space is used besides a few variables.
     */
    public static int[] findMaxSubarrayBruteForce(int[] nums) {
        int maxSoFar = Integer.MIN_VALUE;
        int bestStart = 0;
        int bestEnd = 0;

        for (int i = 0; i < nums.length; i++) {
            int currentSum = 0;
            for (int j = i; j < nums.length; j++) {
                currentSum += nums[j];
                if (currentSum > maxSoFar) {
                    maxSoFar = currentSum;
                    bestStart = i;
                    bestEnd = j;
                }
            }
        }
        
        return Arrays.copyOfRange(nums, bestStart, bestEnd + 1);
    }

    /**
     * Optimal Approach: Modified Kadane's Algorithm
     * This method uses Kadane's algorithm to find the max sum in O(N) time.
     * It is modified to keep track of the start and end indices of the maximum
     * subarray found so far.
     * Time: O(N) - A single pass through the array.
     * Space: O(1) - Only a few extra variables are used.
     */
    public static int[] findMaxSubarrayOptimal(int[] nums) {
        int maxSoFar = Integer.MIN_VALUE;
        int currentSum = 0;
        
        int bestStart = 0;
        int bestEnd = 0;
        int currentStart = 0;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];

            // If we found a new maximum sum, update our best variables
            if (currentSum > maxSoFar) {
                maxSoFar = currentSum;
                bestStart = currentStart;
                bestEnd = i;
            }

            // If currentSum becomes negative, abandon the current subarray
            // and start a new one from the next element.
            if (currentSum < 0) {
                currentSum = 0;
                currentStart = i + 1;
            }
        }
        
        return Arrays.copyOfRange(nums, bestStart, bestEnd + 1);
    }

    // Quick demo
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println("Original Array: " + Arrays.toString(nums));

        int[] bruteForceResult = findMaxSubarrayBruteForce(nums);
        System.out.println("Max Subarray (Brute Force O(N^2)): " + Arrays.toString(bruteForceResult));

        int[] optimalResult = findMaxSubarrayOptimal(nums);
        System.out.println("Max Subarray (Optimal O(N)): " + Arrays.toString(optimalResult));
        
        // Expected: [4, -1, 2, 1]
    }
}