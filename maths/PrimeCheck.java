

package maths;

import java.util.*;

public class PrimeCheck {
    // Naive approach: O(n)
    public static boolean isPrimeNaive(int n) {
        if (n <= 1) return false;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    /**
     * Optimized primality check.
     * Time Complexity: O(√n) because we only check divisibility up to the square root of n, skipping obvious multiples of 2 and 3.
     * Space Complexity: O(1) because we use only a few extra variables regardless of input size.
     */
    public static boolean isPrimeOptimized(int n) {
        if (n <= 1) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;

        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        System.out.println("Naive check: " + (isPrimeNaive(n) ? "Prime" : "Not Prime"));
        System.out.println("Optimized check: " + (isPrimeOptimized(n) ? "Prime" : "Not Prime"));
    }
}