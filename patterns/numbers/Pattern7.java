package patterns.numbers;

import java.util.*;

/*

Pattern 7: Centered Number Pyramid

For n = 5, output is:

    1
   1 2
  1 2 3
 1 2 3 4
1 2 3 4 5

*/


public class Pattern7 {
    public static void main(String[] args) {
        // take input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        // logic
        for(int i = 1; i <= n; i++){
            System.out.print(" ".repeat(n - i));

            for(int j = 1; j <= i; j++){
                System.out.print(j + " ");
            }

            System.out.println();
        }

        sc.close();
    }
}
