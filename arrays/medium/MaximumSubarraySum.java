package arrays.medium;

public class MaximumSubarraySum {

    /**
     * Brute Force: O(n^2) time, O(1) space
     * Try every subarray [i..j], accumulating sum on the fly.
     */
    public static int maxSubarrayBrute(int[] arr) {
        if (arr == null || arr.length == 0) throw new IllegalArgumentException("Empty array");
        int n = arr.length;

        int best = arr[0]; // init with first element to handle all-negative arrays
        for (int i = 0; i < n; i++) {
            int run = 0;
            for (int j = i; j < n; j++) {
                run += arr[j];           // sum of subarray [i..j]
                if (run > best) best = run;
            }
        }
        return best;
    }

    /**
     * Optimal (Kadane's Algorithm): O(n) time, O(1) space
     * curr = best sum of a subarray that ends at index i (must include arr[i])
     * best = global maximum subarray sum so far
     */
    public static int maxSubarrayKadane(int[] arr) {
        if (arr == null || arr.length == 0) throw new IllegalArgumentException("Empty array");

        int curr = arr[0];
        int best = arr[0];

        for (int i = 1; i < arr.length; i++) {
            // Either extend previous subarray or start fresh at arr[i]
            curr = Math.max(arr[i], curr + arr[i]);
            if (curr > best) best = curr;
        }
        return best;
    }

    // Quick demo
    public static void main(String[] args) {
        int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4}; // answer = 6 ( [4,-1,2,1] )
        System.out.println("Brute:  " + maxSubarrayBrute(a));   // 6
        System.out.println("Kadane: " + maxSubarrayKadane(a));  // 6
    }
}