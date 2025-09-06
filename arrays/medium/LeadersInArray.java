package arrays.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeadersInArray {

    /**
     * Brute Force: Nested Loops
     * For each element, this approach iterates through all the elements to its right
     * to check if it's a leader.
     * Time: O(N^2) - For each element, we might scan a large portion of the array.
     * Space: O(N) - In the worst case, all elements are leaders and are stored.
     */
    public static List<Integer> findLeadersBruteForce(int[] nums) {
        List<Integer> leaders = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            boolean isLeader = true;
            // Check all elements to the right
            for (int j = i + 1; j < n; j++) {
                if (nums[j] > nums[i]) {
                    isLeader = false; // Found a greater element, so it's not a leader
                    break;
                }
            }
            if (isLeader) {
                leaders.add(nums[i]);
            }
        }
        return leaders;
    }

    /**
     * Optimal: Single Pass from Right
     * This approach iterates from the right side of the array once. It keeps track
     * of the maximum element found so far. An element is a leader if it is greater
     * than the current maximum from the right.
     * Time: O(N) - A single pass through the array.
     * Space: O(N) - To store the leaders in the worst case.
     */
    public static List<Integer> findLeadersOptimal(int[] nums) {
        List<Integer> leaders = new ArrayList<>();
        int n = nums.length;
        if (n == 0) {
            return leaders;
        }

        // The rightmost element is always a leader
        int maxFromRight = nums[n - 1];
        leaders.add(maxFromRight);

        // Iterate from the second to last element to the beginning
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] >= maxFromRight) {
                // This element is a leader
                leaders.add(nums[i]);
                // Update the new maximum from the right
                maxFromRight = nums[i];
            }
        }
        
        // The leaders are found in reverse order, so we reverse the list
        // to get the correct order from left to right.
        Collections.reverse(leaders);
        return leaders;
    }

    // Quick demo
    public static void main(String[] args) {
        int[] arr = {10, 22, 12, 3, 0, 6};

        System.out.println("Original Array: " + java.util.Arrays.toString(arr));

        List<Integer> leadersBrute = findLeadersBruteForce(arr);
        System.out.println("Leaders (Brute Force): " + leadersBrute); // Expected: [22, 12, 6] -> Correction: [22, 6]

        List<Integer> leadersOptimal = findLeadersOptimal(arr);
        System.out.println("Leaders (Optimal):     " + leadersOptimal); // Expected: [22, 6]
        
        System.out.println("---");
        
        int[] arr2 = {16, 17, 4, 3, 5, 2};
        System.out.println("Original Array: " + java.util.Arrays.toString(arr2));
        List<Integer> leadersOptimal2 = findLeadersOptimal(arr2);
        System.out.println("Leaders (Optimal):     " + leadersOptimal2); // Expected: [17, 5, 2]
    }
}