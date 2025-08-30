package patterns.numbers;

import java.util.*;

/*

Pattern 5: Floyd’s Triangle

For n = 5, output is:

1
2 3
4 5 6
7 8 9 10
11 12 13 14 15

*/

public class Pattern5{
    public static void main(String[] args){
        // take input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        // logic
        int k = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                System.out.print(k++ + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
