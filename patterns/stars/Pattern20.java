package patterns.stars;

import java.util.*;

/*

Pattern 20: Checkerboard

For n = 6, output should be:

* * * *
 * * * 
* * * *
 * * * 
* * * *
 * * * 

*/

// i -> odd (star in odd places)
// i -> even (star in even places)
public class Pattern20 {
  public static void main(String[] args) {
    // setup input
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter n: ");
    int n = sc.nextInt();

    // logic
    // outer loop for rows
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        boolean star = ((i + j) % 2 == 0); // top-left (1,1) is '*'
        System.out.print(star ? "*" : " ");
      }
      System.out.println();
    }

    sc.close();
  }
}