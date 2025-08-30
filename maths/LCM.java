package maths;

import java.util.*;

public class LCM {
    // Euclidean Algorithm for GCD
    public static int gcd(int a, int b) {
        if (b == 0) return Math.abs(a);
        return gcd(b, a % b);
    }

    // LCM using formula: (a * b) / gcd(a, b)
    public static long lcm(int a, int b) {
        return (long)Math.abs((long)a * b) / gcd(a, b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int a = sc.nextInt();

        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        System.out.println("LCM of " + a + " and " + b + " = " + lcm(a, b));
    }
}