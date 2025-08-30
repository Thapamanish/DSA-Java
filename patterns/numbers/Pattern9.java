package patterns.numbers;

import java.util.*;

/*

Pattern 9: Palindromic Number Pyramid

For n = 5, output is:

    1
   121
  12321
 1234321
123454321

*/




public class Pattern9 {
    public static void main(String[] args) {
        // take input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        // logic
        for(int i = 1; i <= n; i++){
            System.out.print(" ".repeat(n - i));

            for(int j = 1; j <= i; j++){
                System.out.print(j);
            }

            for(int j = i - 1; j >= 1; j--){
                System.out.print(j);
            }

            System.out.println();
        }

        sc.close();
    }
}
