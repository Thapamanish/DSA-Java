package sorting.heapsort;

import java.util.*;

/**
 * Heap Sort (ascending) using a Max-Heap.
 *
 * Time Complexity:  O(N log N)
 *   - Build heap: O(N)
 *   - N extractions: N * O(log N)
 * Space Complexity: O(1) (in-place)
 * Stability: Not stable
 *
 * Idea:
 * 1) Build a max-heap from the array (largest element at root, index 0).
 * 2) Repeatedly swap the root with the last element of the heap section,
 *    shrink heap size by 1, and heapify to restore the max-heap property.
 */
public class HeapSort {

    // Public API: sorts arr in ascending order
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // 1) Build Max-Heap in-place (start from last non-leaf node).
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i); // ensure subtree rooted at i is a max-heap
        }

        // 2) Extract max one by one and place it at the end of the array.
        for (int end = n - 1; end > 0; end--) {
            swap(arr, 0, end);       // move current max (root) to its final spot
            heapify(arr, end, 0);    // restore max-heap on the reduced range [0..end-1]
        }
    }

    /**
     * Heapify the subtree rooted at index 'i' within the array prefix of size 'heapSize'.
     * Assumes the left and right subtrees of 'i' are already max-heaps; fixes node 'i'.
     *
     * @param arr      the array
     * @param heapSize number of elements considered part of the heap (prefix [0..heapSize-1])
     * @param i        root index of the subtree to heapify
     */
    private static void heapify(int[] arr, int heapSize, int i) {
        int largest = i;
        int left    = 2 * i + 1;
        int right   = 2 * i + 2;

        // If left child exists and is greater than current largest
        if (left < heapSize && arr[left] > arr[largest]) {
            largest = left;
        }

        // If right child exists and is greater than current largest
        if (right < heapSize && arr[right] > arr[largest]) {
            largest = right;
        }

        // If root is not largest, swap with the larger child and continue heapifying
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, heapSize, largest);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i]; arr[i] = arr[j]; arr[j] = tmp;
    }

    // Demo
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        System.out.println("Before sorting: " + Arrays.toString(arr));
        heapSort(arr);
        System.out.println("After sorting : " + Arrays.toString(arr));

        sc.close();
    }
}