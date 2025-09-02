package arrays.easy;

public class LinearSearch {

    /**
     * Performs a linear search for target in arr.
     * @param arr array to search
     * @param target value to find
     * @return index of first occurrence, or -1 if not found
     */
    public static int search(int[] arr, int target) {
        if (arr == null || arr.length == 0) return -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // found
            }
        }
        return -1; // not found
    }

    // Quick demo
    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4};
        System.out.println(search(arr, 8)); // 2
        System.out.println(search(arr, 7)); // -1
        System.out.println(search(arr, 5)); // 0
    }
}