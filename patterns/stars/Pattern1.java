package patterns.stars;

import java.util.*;

/*

Pattern 1: Right-Angled Triangle of Stars

For n = 5, output is:

*
**
***
****
*****

*/

public class Pattern1{
    public static void main(String[] args){
        // setup input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        // logic
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                System.out.print("*");
            }
            System.out.println();
        }

        sc.close();
    }
}