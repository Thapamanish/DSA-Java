package patterns.stars;

import java.util.*;

/*

Pattern 18: Square border + both diagonals.

For n = 5, output should be:

*****
** ** 
* * *
** ** 
*****

*/

public class Pattern18 {
  public static void main(String[] args) {
    // setup input
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter n: ");
    int n = sc.nextInt();

    // logic
    // outer loop for rows

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        boolean onBorder = (i == 1 || i == n || j == 1 || j == n);
        boolean onDiag = (i == j || i + j == n + 1);
        System.out.print((onBorder || onDiag) ? "*" : " ");                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           

      }
      System.out.println();
    }

    sc.close();
  }
}