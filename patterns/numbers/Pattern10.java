package patterns.numbers;

import java.util.*;

/*

Pattern 10: Diamond of Numbers (Palindromic)

For n = 5, output is:

    1
   121
  12321
 1234321
123454321
 1234321
  12321
   121
    1

*/

public class Pattern10 {
    public static void main(String[] args) {
        // take input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        // logic
        for (int i = 1; i <= 2 * n - 1; i++) {
            System.out.print(" ".repeat(Math.abs(n - i)));

            if (i <= n) {
                for (int j = 1; j <= i; j++) {
                    System.out.print(j);
                }
            } else {
                for (int j = 1; j <= 2 * n - i; j++) {
                    System.out.print(j);
                }
            }

            if (i <= n) {
                for (int j = i - 1; j >= 1; j--) {
                    System.out.print(j);
                }
            } else {
                for (int j = 2 * n - i - 1; j >= 1; j--) {
                    System.out.print(j);
                }
            }

            System.out.println();
        }

        sc.close();
    }
}
