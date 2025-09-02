package arrays.easy;

import java.util.Arrays;

public class RemoveDuplicatesSorted {

    /**
     * Removes duplicates from a sorted array in-place.
     * @param arr sorted array (non-decreasing)
     * @return k = count of unique elements; arr[0..k-1] are the uniques
     *
     * Example:
     * arr = [1,1,2,2,2,3] => returns 3; arr becomes [1,2,3,2,2,3] and use first 3.
     */
    public static int removeDuplicates(int[] arr) {
        if (arr == null || arr.length == 0) return 0;

        int k = 1; // write index for next unique (arr[0] is always unique)
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[k - 1]) { // found a new unique
                arr[k] = arr[i];
                k++;
            }
        }
        return k;
    }

    // Quick demo
    public static void main(String[] args) {
        int[] arr = {1,1,2,2,2,3,3,4,5,5};
        int k = removeDuplicates(arr);
        System.out.println("Unique count: " + k);
        System.out.println("Unique segment: " + Arrays.toString(Arrays.copyOf(arr, k)));
        // Output:
        // Unique count: 5
        // Unique segment: [1, 2, 3, 4, 5]
    }
}