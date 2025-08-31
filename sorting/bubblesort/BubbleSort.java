package sorting.bubblesort;

import java.util.*;

/**
 * Bubble Sort (ascending)
 * Time Complexity: O(N^2) worst & average, O(N) best (when already sorted with no swaps)
 * Space Complexity: O(1) — in-place
 * Stability: Stable (equal elements do not swap positions unnecessarily)
 *
 * Idea:
 * Repeatedly "bubble up" the largest element to the end by swapping adjacent out-of-order pairs.
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            // After each pass, the largest element "bubbles up" to the end
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap adjacent elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no swaps in this pass, array is already sorted
            if (!swapped) break;
        }
    }

    // Demo
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        System.out.println("Before: " + Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("After : " + Arrays.toString(arr));
    }
}