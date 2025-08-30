package patterns.stars;

import java.util.*;

/*

Pattern 13: Right Half Butterfly (Half Diamond, Right Aligned).

For n = 5, output should be:

    *
   **
  ***
 ****
*****
 ****
  ***
   **
    *

*/

public class Pattern13 {
    public static void main(String[] args) {
        // setup input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        // logic
        // outer loop for rows

        for(int i = 1; i <= 2*n - 1; i++){  
            int spaces = (i <= n) ? (n - i) : (i - n);
            int stars = (i <= n) ? i : (2*n - i);

            System.out.print(" ".repeat(spaces));
            System.out.println("*".repeat(stars));
        }
        

        sc.close();
    }
}