package arrays.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarraySumK {

    /**
     * Returns length of the longest subarray with sum exactly K.
     * Works with positives, zeros, and negatives.
     * Time: O(n), Space: O(n).
     */
    public static int longestSubarrayLen(int[] arr, int K) {
        if (arr == null || arr.length == 0) return 0;

        Map<Integer, Integer> first = new HashMap<>();
        first.put(0, -1);              // prefix sum 0 occurs before the array

        int pref = 0, best = 0;

        for (int i = 0; i < arr.length; i++) {
            pref += arr[i];

            int need = pref - K;        // we want an earlier prefix equal to need
            if (first.containsKey(need)) {
                best = Math.max(best, i - first.get(need));
            }

            // store FIRST occurrence only (earliest gives longest window)
            first.putIfAbsent(pref, i);
        }
        return best;
    }

    // Quick demo
    public static void main(String[] args) {
        System.out.println(longestSubarrayLen(new int[]{1, -1, 5, -2, 3}, 3)); // 4
        System.out.println(longestSubarrayLen(new int[]{-1, 2, 3, -2, 5}, 3)); // 4
        System.out.println(longestSubarrayLen(new int[]{2, -2, 2, -2}, 0));    // 4
        System.out.println(longestSubarrayLen(new int[]{1, 2, 3}, 7));         // 0
    }
}