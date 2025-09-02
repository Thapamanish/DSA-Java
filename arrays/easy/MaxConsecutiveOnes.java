package arrays.easy;

public class MaxConsecutiveOnes {

    /**
     * Returns the maximum number of consecutive 1s in a binary array.
     * Single pass: keep a running count and a best-so-far.
     * Time O(n), Space O(1).
     */
    public static int findMaxConsecutiveOnes(int[] arr) {
        if (arr == null || arr.length == 0) return 0;

        int best = 0;
        int curr = 0;

        for (int v : arr) {
            if (v == 1) {
                curr++;           // extend the current streak
                if (curr > best) best = curr;
            } else {
                curr = 0;         // reset streak at a zero
            }
        }
        return best;
    }

    // Quick demo
    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1})); // 3
        System.out.println(findMaxConsecutiveOnes(new int[]{0,0,0}));       // 0
        System.out.println(findMaxConsecutiveOnes(new int[]{1,1,1,1}));     // 4
        System.out.println(findMaxConsecutiveOnes(new int[]{1,0,1,1,0,1})); // 2
    }
}