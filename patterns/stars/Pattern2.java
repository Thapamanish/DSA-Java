package patterns.stars;

import java.util.*;

/*

Pattern 2: Right-aligned triangle

For n = 5, output is:

    *
   **
  ***
 ****
*****

*/

public class Pattern2 {
    public static void main(String[] args) {
        // setup input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        // logic
        // outer loop for rows
        for (int i = 1; i <= n; i++) {
            // print spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            // print stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println(); // move to next line

            sc.close();
        }
    }
}