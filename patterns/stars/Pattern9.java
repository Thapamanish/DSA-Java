package patterns.stars;

import java.util.*;

/*

Pattern 9: Hollow Pyramid.

For n = 5, output should be:

    *
   * *
  *   *
 *     *
*********

*/

public class Pattern9 {
    public static void main(String[] args) {
        // setup input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        // logic
        // outer loop for rows
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n - i; j++){
                System.out.print(" ");
            }

            for(int j = 1; j <= 2 * i - 1; j++){
                if(j == 1 || j == 2 * i - 1 || i == n){
                    System.out.print("*");
                } else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        sc.close();
    }
}