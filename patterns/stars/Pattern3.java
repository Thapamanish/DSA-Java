package patterns.stars;

import java.util.*;

/*

Pattern 3: Inverted left-aligned triangle

For n = 5, output is:

*****
****
***
**
*

*/

public class Pattern3 {
    public static void main(String[] args) {
        // setup input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        // logic
        // outer loop for rows
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println(); // move to next line
        }
        sc.close();
    }
}