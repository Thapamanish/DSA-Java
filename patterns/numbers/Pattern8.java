package patterns.numbers;

import java.util.*;

/*

Pattern 8: Inverted Centered Number Pyramid

For n = 5, output is:

1 2 3 4 5
 1 2 3 4
  1 2 3
   1 2
    1

*/



public class Pattern8 {
    public static void main(String[] args) {
        // take input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        // logic
        for(int i = 1; i <= n; i++){
            System.out.print(" ".repeat(i - 1));

            for(int j = 1; j <= n - i + 1; j++){
                System.out.print(j + " ");
            }

            System.out.println();
        }

        sc.close();
    }
}
