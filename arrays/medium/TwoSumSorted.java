package arrays.medium;

import java.util.Arrays;

public class TwoSumSorted {

    /**
     * Two-pointer method for a sorted array.
     * Returns indices (in the original sorted array) or [-1, -1] if not found.
     * Time: O(n), Space: O(1).
     */
    public static int[] twoSumSorted(int[] arr, int target) {
        if (arr == null || arr.length < 2) return new int[]{-1, -1};
        int l = 0, r = arr.length - 1;

        while (l < r) {
            int sum = arr[l] + arr[r];
            if (sum == target) return new int[]{l, r};
            if (sum < target) l++;
            else r--;
        }
        return new int[]{-1, -1};
    }

    // Quick demo
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSumSorted(new int[]{1,2,3,4,6}, 7))); // [1,4] (2+5? actually 1-based; here 2+5 not present; but 3+4=7 -> [2,3])
        System.out.println(Arrays.toString(twoSumSorted(new int[]{1,3,4,5,7,10}, 8))); // [0,4] (1+7)
        System.out.println(Arrays.toString(twoSumSorted(new int[]{2,3,4}, 6)));       // [0,2]
        System.out.println(Arrays.toString(twoSumSorted(new int[]{1,2,3}, 100)));     // [-1,-1]
    }
}