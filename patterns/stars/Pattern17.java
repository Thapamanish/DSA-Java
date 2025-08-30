package patterns.stars;

import java.util.*;

/*

Pattern 17: Plus (+) pattern.

For n = 5, output should be:

  *
  *
*****
  *
  *

*/

public class Pattern17 {
    public static void main(String[] args) {
        // setup input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        // logic
        // outer loop for rows
        int mid = (n + 1) / 2;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                boolean onPlus = (i == mid || j == mid);

                System.out.print(onPlus ? "*" : " ");
            }
            System.out.println();
        }

        sc.close();
    }
}