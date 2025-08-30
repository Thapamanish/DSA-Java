

package maths;

import java.util.*;

public class Divisors {
    // Naive approach: O(n)
    public static List<Integer> findDivisorsNaive(int n) {
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                divisors.add(i);
            }
        }
        return divisors;
    }

    /**
     * Optimized approach: O(√n)
     * Time Complexity: O(√n) because we only check divisibility up to sqrt(n).
     * Space Complexity: O(√n) in worst case for storing divisors.
     */
    public static List<Integer> findDivisorsOptimized(int n) {
        List<Integer> small = new ArrayList<>();
        List<Integer> large = new ArrayList<>();

        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                small.add(i);
                if (i != n / i) {
                    large.add(n / i);
                }
            }
        }

        Collections.reverse(large);
        small.addAll(large);
        return small;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        System.out.println("Naive divisors: " + findDivisorsNaive(n));
        System.out.println("Optimized divisors (sorted): " + findDivisorsOptimized(n));
    }
}