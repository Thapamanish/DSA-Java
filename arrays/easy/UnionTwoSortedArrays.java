package arrays.easy;

import java.util.*;

public class UnionTwoSortedArrays {

    /**
     * Returns the union (distinct elements) of two sorted arrays in non-decreasing order.
     * Handles duplicates within each array and across arrays.
     * Time: O(n + m), Space: O(n + m) in the worst case for the output list.
     */
    public static List<Integer> unionSorted(int[] a, int[] b) {
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        Integer last = null; // track last appended to avoid duplicates

        while (i < a.length && j < b.length) {
            int x = a[i], y = b[j];

            if (x == y) {
                // append once
                if (last == null || last != x) {
                    res.add(x);
                    last = x;
                }
                // advance both, skipping duplicates within each array
                i++; j++;
            } else if (x < y) {
                if (last == null || last != x) {
                    res.add(x);
                    last = x;
                }
                i++;
            } else { // y < x
                if (last == null || last != y) {
                    res.add(y);
                    last = y;
                }
                j++;
            }
        }

        // drain leftovers
        while (i < a.length) {
            int x = a[i++];
            if (last == null || last != x) {
                res.add(x);
                last = x;
            }
        }
        while (j < b.length) {
            int y = b[j++];
            if (last == null || last != y) {
                res.add(y);
                last = y;
            }
        }

        return res;
    }

    // Quick demo
    public static void main(String[] args) {
        int[] A = {1, 2, 2, 3, 5};
        int[] B = {2, 2, 4, 5, 6, 6};

        System.out.println(unionSorted(A, B)); // [1, 2, 3, 4, 5, 6]

        int[] C = {};
        int[] D = {1, 1, 1};
        System.out.println(unionSorted(C, D)); // [1]

        int[] E = {-3, -1, 0};
        int[] F = {-2, 0, 2};
        System.out.println(unionSorted(E, F)); // [-3, -2, -1, 0, 2]
    }
}