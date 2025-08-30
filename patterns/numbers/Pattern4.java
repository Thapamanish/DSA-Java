package patterns.numbers;

import java.util.*;

/*

Pattern 4: Inverted Right-Aligned Number Triangle

For n = 5, output is:

12345
 1234
  123
   12
    1

*/

public class Pattern4{
    public static void main(String[] args){
        // take input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        // logic
        for(int i = 1; i <= n; i++){
            for(int j = 1; j < i; j++){
                System.out.print(" ");
            }
            
            for(int j = 1; j <= n - i + 1; j++){
                System.out.print(j);
            }
            System.out.println();
        }

        sc.close();
    }
}
