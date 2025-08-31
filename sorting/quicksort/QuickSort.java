package sorting.quicksort;

import java.util.*;

public class QuickSort {

    /**
     * QuickSort algorithm (using Lomuto partition scheme).
     *
     * Time Complexity:
     *   - Best / Average: O(N log N)
     *   - Worst: O(N^2) (happens if pivot choice is always poor, e.g. sorted array with last element pivot)
     *
     * Space Complexity: O(log N) due to recursion stack.
     * Stability: Not stable (equal elements may change relative order).
     */

    // Main QuickSort function
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Partition the array → place pivot in correct position
            int pi = partition(arr, low, high);

            // Recursively sort elements before pivot
            quickSort(arr, low, pi - 1);

            // Recursively sort elements after pivot
            quickSort(arr, pi + 1, high);
        }
    }

    // Partition function (Lomuto scheme: pivot = last element)
    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];  // pivot chosen as last element
        int i = low - 1;        // index for smaller elements

        // Traverse subarray and move smaller elements to the left side
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Place pivot at the correct position (after smaller elements)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1; // return pivot index
    }

    // Demo driver
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        System.out.println("Before sorting: " + Arrays.toString(arr));

        quickSort(arr, 0, n - 1);

        System.out.println("After sorting : " + Arrays.toString(arr));

        sc.close();
    }
}