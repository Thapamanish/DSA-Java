package arrays.easy;

public class LargestElement {
    // Returns the largest element in the array.
    // Throws IllegalArgumentException if the array is empty.
    public static int maxInArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array must have at least one element.");
        }

        int max = arr[0];                        // start with first element
        for (int i = 1; i < arr.length; i++) {   // scan remaining
            if (arr[i] > max) {
                max = arr[i];                    // found a bigger one
            }
        }
        return max;
    }

    // Quick demo
    public static void main(String[] args) {
        int[] arr = { -5, -2, -10, -1, -9 };
        System.out.println("Largest: " + maxInArray(arr)); // prints -1
    }
}