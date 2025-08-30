package patterns.stars;

import java.util.*;

/*

Pattern 19: Z Pattern

For n = 5, output should be:

*****
   *
  *
 *
*****


*/

public class Pattern19 {
  public static void main(String[] args) {
    // setup input
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter n: ");
    int n = sc.nextInt();

    // logic
    // outer loop for rows  
    for(int i = 1; i <= n; i++){
      for(int j = 1; j <= n; j++){
        boolean border = (i == 1 || i == n);
        boolean diag = (i + j == n + 1);

        System.out.print((border || diag) ? "*": " ");
      }
      System.out.println();
    }

    sc.close();
  }
}