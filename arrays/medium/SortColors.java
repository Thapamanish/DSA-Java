package arrays.medium;

import java.util.Arrays;

public class SortColors {

    /**
     * Brute Force: Counting approach
     * Count number of 0s, 1s, and 2s, then overwrite.
     * Time O(n), Space O(1), 2 passes.
     */
    public static void sortColorsCounting(int[] nums) {
        int c0 = 0, c1 = 0, c2 = 0;
        for (int x : nums) {
            if (x == 0) c0++;
            else if (x == 1) c1++;
            else c2++;
        }
        int i = 0;
        while (c0-- > 0) nums[i++] = 0;
        while (c1-- > 0) nums[i++] = 1;
        while (c2-- > 0) nums[i++] = 2;
    }

    /**
     * Optimal: Dutch National Flag algorithm
     * One pass, 3 pointers: low, mid, high
     * Time O(n), Space O(1), 1 pass.
     */
    public static void sortColorsDNF(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++; mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else { // nums[mid] == 2
                swap(nums, mid, high);
                high--; // recheck the swapped value
            }
        }
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i]; a[i] = a[j]; a[j] = t;
    }

    // Quick demo
    public static void main(String[] args) {
        int[] arr1 = {2,0,2,1,1,0};
        int[] arr2 = {2,0,2,1,1,0};

        sortColorsCounting(arr1);
        sortColorsDNF(arr2);

        System.out.println("Counting: " + Arrays.toString(arr1)); // [0,0,1,1,2,2]
        System.out.println("DNF:      " + Arrays.toString(arr2)); // [0,0,1,1,2,2]
    }
}