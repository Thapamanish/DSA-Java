package sorting.mergesort;

import java.util.*;

public class MergeSort {

    // Merge Sort function (recursive)
    static void mergeSort(int[] arr, int low, int high) {
        // Base case: if the subarray has 1 or 0 elements → already sorted
        if (low < high) {
            // Find the middle index
            int mid = low + (high - low) / 2;

            // Recursively sort the left half
            mergeSort(arr, low, mid);

            // Recursively sort the right half
            mergeSort(arr, mid + 1, high);

            // Merge the two sorted halves
            merge(arr, low, mid, high);
        }
    }

    // Merge two sorted subarrays into one
    // Left subarray = arr[low..mid], Right subarray = arr[mid+1..high]
    static void merge(int[] arr, int low, int mid, int high) {
        // Sizes of the two subarrays
        int n1 = mid - low + 1;
        int n2 = high - mid;

        // Create temp arrays
        int[] left = new int[n1];
        int[] right = new int[n2];

        // Copy data into temp arrays
        for (int i = 0; i < n1; i++) {
            left[i] = arr[low + i];
        }
        for (int j = 0; j < n2; j++) {
            right[j] = arr[mid + 1 + j];
        }

        // Indices for traversing left[], right[] and writing to arr[]
        int i = 0, j = 0, k = low;

        // Merge the two temp arrays back into arr[]
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

    // Main driver
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input array
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Before sorting
        System.out.println("Before sorting: " + Arrays.toString(arr));

        // Call merge sort
        mergeSort(arr, 0, n - 1);

        // After sorting
        System.out.println("After sorting: " + Arrays.toString(arr));

        sc.close();
    }
}
