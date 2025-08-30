package patterns.stars;

import java.util.*;

/*

Pattern 15: Hourglass (Sandglass) pattern.

For n = 5, output should be:

*****
****
***
**
*
**
***
****
*****

*/

public class Pattern15 {
    public static void main(String[] args) {
        // setup input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        // logic
        // outer loop for rows
        for (int i = 1; i <= (2 * n - 1); i++) {
            int stars = Math.abs(n - i) + 1;
            int spaces = n - stars;

            System.out.print(" ".repeat(spaces));
            System.out.println("*".repeat(stars));

        }

        sc.close();
    }
}