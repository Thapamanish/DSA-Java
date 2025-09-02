package arrays.easy;

import java.util.Arrays;

public class LeftRotateByOne {

    /**
     * Rotates the array left by one place in-place.
     * If array length <= 1, it does nothing.
     */
    public static void rotateLeftByOne(int[] arr) {
        if (arr == null || arr.length <= 1) return;

        int first = arr[0];                 // save first element
        // shift everything one step left
        for (int i = 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }
        arr[arr.length - 1] = first;        // put saved element at end
    }

    // Quick demo
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        rotateLeftByOne(a);
        System.out.println(Arrays.toString(a)); // [2, 3, 4, 5, 1]

        int[] b = {7};
        rotateLeftByOne(b);
        System.out.println(Arrays.toString(b)); // [7] (unchanged)

        int[] c = {};
        rotateLeftByOne(c);
        System.out.println(Arrays.toString(c)); // [] (unchanged)
    }
}