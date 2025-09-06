package arrays.medium;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    /**
     * Better Approach: Using a HashMap
     * This approach uses a HashMap to store the frequency of each element.
     * It makes one pass to build the map and another to find the majority element.
     * Time: O(N) - We iterate through the array and then the map.
     * Space: O(N) - The HashMap can store up to N/2 distinct elements.
     */
    public static int majorityElementHashMap(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        // Build the frequency map
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Find the element with frequency > n/2
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > n / 2) {
                return entry.getKey();
            }
        }

        return -1; // Should not be reached given the problem constraints
    }

    /**
     * Optimal Approach: Boyer-Moore Voting Algorithm
     * This algorithm finds the majority element in linear time and constant space.
     * It works by maintaining a candidate and a counter. The majority element
     * will "out-vote" all other elements and be the final candidate.
     * Time: O(N) - A single pass through the array.
     * Space: O(1) - Only two extra variables are used.
     */
    public static int majorityElementOptimal(int[] nums) {
        int candidate = 0;
        int counter = 0;

        for (int num : nums) {
            // If the counter is 0, we pick a new candidate
            if (counter == 0) {
                candidate = num;
            }

            // If the current element matches the candidate, increment the counter.
            // Otherwise, decrement it.
            if (num == candidate) {
                counter++;
            } else {
                counter--;
            }
        }

        return candidate;
    }

    // Quick demo
    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        
        System.out.println("Array: " + java.util.Arrays.toString(nums));

        int resultHashMap = majorityElementHashMap(nums);
        System.out.println("Majority Element (HashMap O(N) space): " + resultHashMap);

        int resultOptimal = majorityElementOptimal(nums);
        System.out.println("Majority Element (Optimal O(1) space): " + resultOptimal);
    }
}