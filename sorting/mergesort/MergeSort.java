package sorting.mergesort;

import java.util.*;

public class MergeSort {

    /**
     * Merge Sort algorithm (recursive, divide & conquer)
     * Time Complexity: O(N log N) in all cases
     * Space Complexity: O(N) extra for temporary arrays
     * Stability: Stable (equal elements keep their order)
     */

    // Recursive function to divide array and sort both halves
    static void mergeSort(int[] arr, int low, int high) {
        if (low < high) { // base case: at least 2 elements
            // Find the midpoint
            int mid = low + (high - low) / 2;

            // Sort the left half [low..mid]
            mergeSort(arr, low, mid);

            // Sort the right half [mid+1..high]
            mergeSort(arr, mid + 1, high);

            // Merge the two sorted halves
            merge(arr, low, mid, high);
        }
    }

    // Merge two sorted subarrays into one sorted subarray
    // Left subarray = arr[low..mid], Right subarray = arr[mid+1..high]
    static void merge(int[] arr, int low, int mid, int high) {
        int n1 = mid - low + 1;   // size of left subarray
        int n2 = high - mid;      // size of right subarray

        // Create temporary arrays
        int[] left = new int[n1];
        int[] right = new int[n2];

        // Copy data into temp arrays
        for (int i = 0; i < n1; i++) left[i] = arr[low + i];
        for (int j = 0; j < n2; j++) right[j] = arr[mid + 1 + j];

        // Merge temp arrays back into arr[low..high]
        int i = 0, j = 0, k = low;

        // Compare elements from both arrays and insert the smaller one
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        // Copy any remaining elements of left[]
        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }

        // Copy any remaining elements of right[]
        while (j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    // Main driver to run the algorithm
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        System.out.println("Before sorting: " + Arrays.toString(arr));

        mergeSort(arr, 0, n - 1);

        System.out.println("After sorting : " + Arrays.toString(arr));

        sc.close();
    }
}