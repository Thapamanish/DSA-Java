package arrays.easy;

public class CheckSorted {

    // Returns true if the array is sorted in non-decreasing order.
    public static boolean isSorted(int[] arr) {
        if (arr == null || arr.length <= 1) return true; // empty or single element is sorted
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) return false;       // inversion found
        }
        return true;
    }

    // Optional: strictly increasing (no equal neighbors)
    public static boolean isStrictlyIncreasing(int[] arr) {
        if (arr == null || arr.length <= 1) return true;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] >= arr[i + 1]) return false;
        }
        return true;
    }

    // Quick demo
    public static void main(String[] args) {
        int[] a = {1, 2, 2, 4};
        int[] b = {1, 3, 2};
        System.out.println("a non-decreasing? " + isSorted(a));           // true
        System.out.println("b non-decreasing? " + isSorted(b));           // false
        System.out.println("a strictly increasing? " + isStrictlyIncreasing(a)); // false
    }
}