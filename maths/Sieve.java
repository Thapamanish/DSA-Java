

package maths;

import java.util.*;

public class Sieve {
    /**
     * Sieve of Eratosthenes Algorithm
     * Time Complexity: O(N log log N)
     * Space Complexity: O(N)
     */
    public static List<Integer> sieve(int n) {
        // Create a boolean array "isPrime[0..n]" and initialize all entries as true.
        // A value in isPrime[i] will finally be false if i is Not a prime, else true.
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        if (n >= 1) isPrime[1] = false;

        // Mark non-primes as false using Sieve of Eratosthenes
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                // Mark all multiples of i as not prime
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Collect all prime numbers
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) primes.add(i);
        }
        return primes;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter N: ");
        int n = sc.nextInt();

        List<Integer> primes = sieve(n);
        System.out.println("Primes up to " + n + ": " + primes);
    }
}