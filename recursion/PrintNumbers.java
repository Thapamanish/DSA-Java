package recursion;

import java.util.*;

public class PrintNumbers {
    /**
     * Prints numbers from N to 1 using recursion.
     * Time Complexity: O(N)
     * Space Complexity: O(N) (recursion stack)
     */
    public static void printNto1(int n) {
        if (n == 0) return; // base case
        System.out.print(n + " ");
        printNto1(n - 1);
    }

    /**
     * Prints numbers from 1 to N using recursion.
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public static void print1toN(int n) {
        if (n == 0) return; // base case
        print1toN(n - 1);   // recursive call first
        System.out.print(n + " "); // print on the way back
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter N: ");
        int n = sc.nextInt();

        System.out.print("Numbers from N to 1: ");
        printNto1(n);

        System.out.println();

        System.out.print("Numbers from 1 to N: ");
        print1toN(n);
    }
}