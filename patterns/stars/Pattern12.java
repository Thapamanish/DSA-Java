package patterns.stars;

import java.util.*;

/*

Pattern 12: Left Half Butterfly (Half Diamond).

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

public class Pattern12 {
    public static void main(String[] args) {
        // setup input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        // logic
        // outer loop for rows

        for(int i = 1; i <= 2*n - 1; i++ ){
            int stars = (i <= n) ? i : 2*n - i;
            System.out.println("*".repeat(stars)); 
        }

        

        sc.close();
    }
}