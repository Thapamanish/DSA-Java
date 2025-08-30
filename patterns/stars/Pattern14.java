package patterns.stars;

import java.util.*;

/*

Pattern 14: Full Butterfly.

For n = 5, output should be:

*        *
**      **
***    ***
****  ****
**********
****  ****
***    ***
**      **
*        *

*/

public class Pattern14 {
    public static void main(String[] args) {
        // setup input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        // logic
        // outer loop for rows

        for (int i = 1; i <= (2*n - 1); i++) {
            int stars = (i <= n) ? i : (2*n - i);
            int spaces = (i <= n) ? 2*( n - i) : 2*(i - n);

            System.out.print("*".repeat(stars));
            System.out.print(" ".repeat(spaces));
            System.out.println("*".repeat(stars));
        }

        sc.close();
    }
}