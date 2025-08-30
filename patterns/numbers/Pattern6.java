package patterns.numbers;

import java.util.*;

/*

Pattern 6: Pascal’s Triangle (Basic)

For n = 5, output is:

    1
   1 1
  1 2 1
 1 3 3 1
1 4 6 4 1

*/

public class Pattern6 {
    public static void main(String[] args) {
        // take input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        // logic
        for (int i = 1; i <= n; i++) {
            // leading spaces to center
            System.out.print(" ".repeat(n - i));


            long val = 1;
            for (int j = 1; j <= i; j++) {

                System.out.print(val + " ");
                val = val * (i - j) / j;

            }
            System.out.println();
        }

        sc.close();
    }
}
