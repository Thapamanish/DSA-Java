package arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RearrangeElementsBySign {

    /**
     * Better Approach: Using Extra Space
     * This approach first separates all positive and negative elements into two
     * separate lists. Then, it iterates through these lists to build the final
     * rearranged array.
     * Time: O(N) - We iterate through the array to separate, then again to merge.
     * Space: O(N) - We use two lists that together store all N elements.
     */
    public static int[] rearrangeBruteForce(int[] nums) {
        List<Integer> positives = new ArrayList<>();
        List<Integer> negatives = new ArrayList<>();

        // Step 1: Separate positive and negative numbers
        for (int num : nums) {
            if (num > 0) {
                positives.add(num);
            } else {
                negatives.add(num);
            }
        }

        int[] result = new int[nums.length];
        int posIndex = 0, negIndex = 0;

        // Step 2: Merge the two lists back into the result array
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                // Even indices get positive numbers
                result[i] = positives.get(posIndex++);
            } else {
                // Odd indices get negative numbers
                result[i] = negatives.get(negIndex++);
            }
        }
        return result;
    }

    /**
     * Optimal Approach: Single Pass with Two Pointers
     * This approach uses a single pass through the original array. Two pointers
     * keep track of the next available even (for positives) and odd (for negatives)
     * indices in the result array.
     * Time: O(N) - A single pass through the array.
     * Space: O(N) - To store the final answer array. (Cannot be done in-place
     * without messing up relative order).
     */
    public static int[] rearrangeOptimal(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int posIndex = 0; // Next available even index for a positive number
        int negIndex = 1; // Next available odd index for a negative number

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                result[posIndex] = nums[i];
                posIndex += 2;
            } else {
                result[negIndex] = nums[i];
                negIndex += 2;
            }
        }
        return result;
    }


    // Quick demo
    public static void main(String[] args) {
        int[] arr = {3, 1, -2, -5, 2, -4};
        System.out.println("Original Array: " + Arrays.toString(arr));

        int[] resultBrute = rearrangeBruteForce(arr);
        System.out.println("Result (Brute): " + Arrays.toString(resultBrute)); // Expected: [3, -2, 1, -5, 2, -4]

        int[] resultOptimal = rearrangeOptimal(arr);
        System.out.println("Result (Optimal): " + Arrays.toString(resultOptimal)); // Expected: [3, -2, 1, -5, 2, -4]
    }
}