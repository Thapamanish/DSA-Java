package arrays.easy;

import java.util.Arrays;

public class MoveZerosToEnd {

    /**
     * Moves all zeros to the end in-place while preserving order of non-zero elements.
     * Uses the two-pointer method (O(n) time, O(1) space).
     */
    public static void moveZeros(int[] arr) {
        if (arr == null || arr.length <= 1) return;

        int j = 0; // points to position to place the next non-zero

        // Step 1: Traverse and move non-zeros forward
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[j] = arr[i];
                j++;
            }
        }

        // Step 2: Fill the rest with zeros
        while (j < arr.length) {
            arr[j] = 0;
            j++;
        }
    }

    // Quick demo
    public static void main(String[] args) {
        int[] arr1 = {0, 1, 0, 3, 12};
        moveZeros(arr1);
        System.out.println(Arrays.toString(arr1)); // [1, 3, 12, 0, 0]

        int[] arr2 = {0, 0, 0};
        moveZeros(arr2);
        System.out.println(Arrays.toString(arr2)); // [0, 0, 0]

        int[] arr3 = {1, 2, 3};
        moveZeros(arr3);
        System.out.println(Arrays.toString(arr3)); // [1, 2, 3]
    }
}