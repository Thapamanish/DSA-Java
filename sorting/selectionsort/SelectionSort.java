package sorting.selectionsort;

import java.util.*;

/**
 * Selection Sort (ascending)
 * Time Complexity: O(N^2) in all cases
 * Space Complexity: O(1) — in-place
 * Stability: Not stable (equal elements can reorder)
 *
 * Idea:
 * For each index i, find the minimum element in the suffix [i..n-1] and swap it into position i.
 */
public class SelectionSort {

    // Sorts arr in ascending order using Selection Sort
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;

            // find index of minimum in the unsorted suffix
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }

            // swap the found minimum with the first element of the unsorted part
            if (minIdx != i) {
                swap(arr, i, minIdx);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // Demo: read input, sort, print
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        System.out.println("Before: " + Arrays.toString(arr));
        selectionSort(arr);
        System.out.println("After : " + Arrays.toString(arr));
    }
}