package maths;

import java.util.*;

public class GCD {
    // Iterative Euclidean Algorithm
    public static int gcdIterative(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a); // ensure gcd is always positive
    }

    // Recursive Euclidean Algorithm
    public static int gcdRecursive(int a, int b) {
        if (b == 0) return Math.abs(a);
        return gcdRecursive(b, a % b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int a = sc.nextInt();

        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        System.out.println("GCD (Iterative) of " + a + " and " + b + " = " + gcdIterative(a, b));
        System.out.println("GCD (Recursive) of " + a + " and " + b + " = " + gcdRecursive(a, b));
    }
}
