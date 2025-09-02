package arrays.easy;

public class SingleNumber {

    /**
     * XOR trick:
     * - x ^ x = 0
     * - x ^ 0 = x
     * Pair duplicates cancel out; leftover is the single element.
     * Time O(n), Space O(1).
     */
    public static int singleNumber(int[] nums) {
        int x = 0;
        for (int v : nums) x ^= v;
        return x;
    }

    // Quick demo
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2, 1, 2}));       // 1
        System.out.println(singleNumber(new int[]{4, 1, 2, 1, 2})); // 4
        System.out.println(singleNumber(new int[]{-7, -7, 9}));     // 9
    }
}