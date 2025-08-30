package recursion;

import java.util.*;

public class Factorial {
    /**
     * Recursive factorial function
     * Time Complexity: O(N)
     * Space Complexity: O(N) due to recursion stack
     */
    public static long factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("Factorial not defined for negative numbers");
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        try {
            System.out.println("Factorial of " + n + " = " + factorial(n));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}