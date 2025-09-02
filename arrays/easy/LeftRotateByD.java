package arrays.easy;

import java.util.Arrays;

public class LeftRotateByD {

    /**
     * Approach 1 (Extra Space): O(n) time, O(n) space
     * Copy first d elements to temp, shift the rest left, put temp at end.
     */
    public static void rotateLeftExtraSpace(int[] arr, int d) {
        if (arr == null || arr.length <= 1) return;
        int n = arr.length;
        d = ((d % n) + n) % n; // normalize d (handles d >= n and negative)

        if (d == 0) return;

        int[] temp = Arrays.copyOf(arr, d);        // first d
        for (int i = d; i < n; i++) {
            arr[i - d] = arr[i];                   // shift left
        }
        for (int i = 0; i < d; i++) {
            arr[n - d + i] = temp[i];              // append saved
        }
    }

    /**
     * Approach 2 (Reversal Algorithm): O(n) time, O(1) space
     * Steps:
     * 1) reverse [0..d-1]
     * 2) reverse [d..n-1]
     * 3) reverse [0..n-1]
     */
    public static void rotateLeftReversal(int[] arr, int d) {
        if (arr == null || arr.length <= 1) return;
        int n = arr.length;
        d = ((d % n) + n) % n; // normalize

        if (d == 0) return;

        reverse(arr, 0, d - 1);
        reverse(arr, d, n - 1);
        reverse(arr, 0, n - 1);
    }

    private static void reverse(int[] a, int l, int r) {
        while (l < r) {
            int t = a[l];
            a[l] = a[r];
            a[r] = t;
            l++; r--;
        }
    }

    // Quick demo
    public static void main(String[] args) {
        int[] A = {1,2,3,4,5,6,7};
        rotateLeftExtraSpace(A, 2);
        System.out.println("Extra space d=2: " + Arrays.toString(A)); // [3,4,5,6,7,1,2]

        int[] B = {1,2,3,4,5,6,7};
        rotateLeftReversal(B, 2);
        System.out.println("Reversal d=2:    " + Arrays.toString(B)); // [3,4,5,6,7,1,2]

        int[] C = {1,2,3,4,5};
        rotateLeftReversal(C, 12); // d > n handled
        System.out.println("Reversal d=12:   " + Arrays.toString(C)); // [3,4,5,1,2]

        int[] D = {1,2,3,4,5};
        rotateLeftReversal(D, -1); // negative d → left by n-1
        System.out.println("Reversal d=-1:   " + Arrays.toString(D)); // [2,3,4,5,1]
    }
}