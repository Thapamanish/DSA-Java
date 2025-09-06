package arrays.medium;

import java.util.HashMap;
import java.util.Map;

public class CountSubarraysWithSumK {

    /**
     * Brute Force Approach
     * This approach checks every possible continuous subarray. The outer loop fixes
     * the starting point, and the inner loop iterates through all possible end points,
     * keeping a running sum.
     * Time: O(N^2) - Two nested loops.
     * Space: O(1) - No extra space is used besides a few variables.
     */
    public static int subarraySumBruteForce(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int currentSum = 0;
            for (int j = i; j < nums.length; j++) {
                currentSum += nums[j];
                if (currentSum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Optimal Approach: Prefix Sum with HashMap
     * This approach solves the problem in a single pass. It uses a HashMap to
     * store the frequency of each prefix sum encountered so far.
     * Time: O(N) - We iterate through the array only once.
     * Space: O(N) - In the worst case, the HashMap could store N distinct prefix sums.
     */
    public static int subarraySumOptimal(int[] nums, int k) {
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        int count = 0;
        int currentSum = 0;

        // Base case: A prefix sum of 0 has been seen once (before the array starts).
        prefixSumMap.put(0, 1);

        for (int num : nums) {
            currentSum += num;
            int target = currentSum - k;

            if (prefixSumMap.containsKey(target)) {
                count += prefixSumMap.get(target);
            }

            prefixSumMap.put(currentSum, prefixSumMap.getOrDefault(currentSum, 0) + 1);
        }
        return count;
    }

    // Quick demo
    public static void main(String[] args) {
        int[] nums = {3, 4, 7, 2, -3, 1, 4, 2};
        int k = 7;

        System.out.println("Array: " + java.util.Arrays.toString(nums));
        System.out.println("k: " + k);

        int bruteForceResult = subarraySumBruteForce(nums, k);
        System.out.println("\nResult (Brute Force O(N^2)): " + bruteForceResult);

        int optimalResult = subarraySumOptimal(nums, k);
        System.out.println("Result (Optimal O(N)): " + optimalResult);
        
        // Expected for {3, 4, 7, 2, -3, 1, 4, 2} and k=7 are:
        // [3, 4], [7], [7, 2, -3, 1], [2, -3, 1, 4, 2] -> 4 subarrays
    }
}