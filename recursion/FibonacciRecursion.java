package recursion;

import java.util.*;

public class FibonacciRecursion {
    /**
     * Recursive Fibonacci function
     * Time Complexity: O(2^n) due to repeated subproblems
     * Space Complexity: O(n) recursion stack
     */
    public static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        System.out.println("Fibonacci series up to " + n + " terms:");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }
}