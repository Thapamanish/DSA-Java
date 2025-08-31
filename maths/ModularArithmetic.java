package maths;

import java.util.*;

public class ModularArithmetic {
    /**
     * Fast exponentiation (modular power)
     * Computes (base^exp) % mod efficiently.
     * Time Complexity: O(log exp)
     * Space Complexity: O(1)
     */
    public static long modPow(long base, long exp, long mod) {
        long result = 1;
        base %= mod;

        while (exp > 0) {
            if ((exp & 1) == 1) { // if exp is odd
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1; // divide exp by 2
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        long a = sc.nextLong();

        System.out.print("Enter second number: ");
        long b = sc.nextLong();

        System.out.print("Enter modulus: ");
        long m = sc.nextLong();

        System.out.println("Addition: (" + a + " + " + b + ") % " + m + " = " + ((a % m + b % m) % m));
        System.out.println("Subtraction: (" + a + " - " + b + ") % " + m + " = " + (((a % m - b % m) + m) % m));
        System.out.println("Multiplication: (" + a + " * " + b + ") % " + m + " = " + ((a % m * b % m) % m));

        System.out.print("Enter exponent for modular power: ");
        long exp = sc.nextLong();

        System.out.println("Exponentiation: (" + a + "^" + exp + ") % " + m + " = " + modPow(a, exp, m));
    }
}