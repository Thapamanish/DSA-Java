package arrays.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    /**
     * Better Approach: Sorting
     * This approach first sorts the array, which makes it easy to find consecutive
     * elements by just iterating through the array once. It's a solid, intuitive approach.
     * Time: O(N log N) - Dominated by the sorting algorithm.
     * Space: O(1) - If sorting is done in-place.
     */
    public static int longestConsecutiveSorting(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int longestStreak = 1;
        int currentStreak = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) { // Skip duplicates
                if (nums[i] == nums[i-1] + 1) {
                    // It's a consecutive number
                    currentStreak++;
                } else {
                    // The streak is broken
                    longestStreak = Math.max(longestStreak, currentStreak);
                    currentStreak = 1; // Reset for the new number
                }
            }
        }
        
        // Final check to see if the last streak was the longest
        return Math.max(longestStreak, currentStreak);
    }

    /**
     * Optimal Approach: HashSet
     * This approach uses a HashSet for O(1) lookups. It iterates through the numbers,
     * and for each number, it only starts counting a sequence if it's the beginning
     * of one. This avoids redundant checks and achieves linear time complexity.
     * Time: O(N) - We add N elements to the set and then iterate through N elements.
     * Space: O(N) - To store all the numbers in the HashSet.
     */
    public static int longestConsecutiveOptimal(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        for (int num : numSet) {
            // Check if it's the start of a sequence
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Count the length of the sequence
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    // Quick demo
    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};
        System.out.println("Original Array: " + Arrays.toString(arr));

        int lengthSorting = longestConsecutiveSorting(arr);
        System.out.println("Length (Sorting): " + lengthSorting); // Expected: 4

        int lengthOptimal = longestConsecutiveOptimal(arr);
        System.out.println("Length (Optimal): " + lengthOptimal); // Expected: 4

        System.out.println("---");

        int[] arr2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println("Original Array: " + Arrays.toString(arr2));
        int lengthOptimal2 = longestConsecutiveOptimal(arr2);
        System.out.println("Length (Optimal): " + lengthOptimal2); // Expected: 9
    }
}