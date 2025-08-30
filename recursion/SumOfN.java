

package recursion;

import java.util.*;

public class SumOfN {
    /**
     * Recursive approach
     * Time Complexity: O(N)
     * Space Complexity: O(N) due to recursion stack
     */
    public static int sumRecursive(int n) {
        if (n == 0) return 0;
        return n + sumRecursive(n - 1);
    }

    /**
     * Formula approach: n(n+1)/2
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public static int sumFormula(int n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter N: ");
        int n = sc.nextInt();

        System.out.println("Sum using recursion: " + sumRecursive(n));
        System.out.println("Sum using formula: " + sumFormula(n));
    }
}