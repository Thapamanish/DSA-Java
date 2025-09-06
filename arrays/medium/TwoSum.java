package arrays.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class TwoSum {

    /**
     * Returns indices [i, j] such that arr[i] + arr[j] == target (i != j).
     * If no pair exists, returns [-1, -1].
     * Time: O(n), Space: O(n).
     */
    public static int[] twoSum(int[] arr, int target) {
        if (arr == null || arr.length < 2) return new int[]{-1, -1};

        Map<Integer, Integer> seen = new HashMap<>(); // value -> index
        for (int i = 0; i < arr.length; i++) {
            int need = target - arr[i];
            if (seen.containsKey(need)) {
                return new int[]{seen.get(need), i};
            }
            // store first occurrence only (keeps earliest index)
            seen.putIfAbsent(arr[i], i);
        }
        return new int[]{-1, -1};
    }

    // Quick demo
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2,7,11,15}, 9))); // [0,1]
        System.out.println(Arrays.toString(twoSum(new int[]{3,2,4}, 6)));     // [1,2]
        System.out.println(Arrays.toString(twoSum(new int[]{3,3}, 6)));       // [0,1]
        System.out.println(Arrays.toString(twoSum(new int[]{1,2,3}, 7)));     // [-1,-1]
    }
}