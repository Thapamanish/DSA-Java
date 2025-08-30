package patterns.stars;

import java.util.*;

/*

Pattern 11: Hollow Diamond.

For n = 5, output should be:

    *
   * *
  *   *
 *     *
*       *
 *     *
  *   *
   * *
    *

*/

public class Pattern11 {
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
                if( j == 1 || j == 2 * i - 1){
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        for(int i = n - 1; i >= 1; i--){
            for(int j = 1; j <= n - i; j++){
                System.out.print(" ");
            }

            for(int j = 1; j <= 2 * i - 1; j++){
                if(j == 1 || j == 2 * i - 1){
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        sc.close();
    }
}