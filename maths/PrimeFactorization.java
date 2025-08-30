

package maths;

import java.util.*;

public class PrimeFactorization {
    // Naive approach: O(n)
    public static List<Integer> primeFactorsNaive(int n) {
        List<Integer> factors = new ArrayList<>();
        if (n <= 1) return factors;

        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        return factors;
    }

    /**
     * Optimized approach: O(√n)
     * Time Complexity: O(√n) because we only check up to the square root of n.
     * Space Complexity: O(log n) in worst case (for storing factors).
     */
    public static List<Integer> primeFactorsOptimized(int n) {
        List<Integer> factors = new ArrayList<>();
        if (n <= 1) return factors;

        // Handle factor 2 separately
        while (n % 2 == 0) {
            factors.add(2);
            n /= 2;
        }

        // Check odd numbers from 3 to sqrt(n)
        for (int i = 3; i * i <= n; i += 2) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }

        // If n > 2, then n is prime
        if (n > 2) {
            factors.add(n);
        }

        return factors;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        System.out.println("Naive factors: " + primeFactorsNaive(n));
        System.out.println("Optimized factors: " + primeFactorsOptimized(n));
    }
}