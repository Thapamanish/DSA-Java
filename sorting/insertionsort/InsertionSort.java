package sorting.insertionsort;

import java.util.*;

/**
 * Insertion Sort (ascending)
 * Time Complexity:
 *   - Best: O(N) when already sorted
 *   - Worst/Average: O(N^2)
 * Space Complexity: O(1) in-place
 * Stability: Stable (equal elements preserve order)
 *
 * Idea:
 * Treat the left part of the array as sorted.
 * Take the current element (key) and "insert" it into the correct position in the sorted part.
 */
public class InsertionSort {

    public static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];   // current element to insert
            int j = i - 1;

            // Shift all larger elements one step to the right
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            // Place key in its correct spot
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        System.out.println("Before sorting: " + Arrays.toString(arr));
        insertionSort(arr);
        System.out.println("After sorting : " + Arrays.toString(arr));

        sc.close();
    }
}