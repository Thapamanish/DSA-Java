package recursion;

import java.util.*;

public class NameNTimes {
    /**
     * Prints a name N times using recursion.
     * Time Complexity: O(N)
     * Space Complexity: O(N) (due to recursion stack)
     */
    public static void printName(int n, String name) {
        if (n == 0) return; // base case
        System.out.println(name);
        printName(n - 1, name); // recursive call
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter N: ");
        int n = sc.nextInt();

        printName(n, name);
    }
}