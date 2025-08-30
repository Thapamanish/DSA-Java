package patterns.numbers;

import java.util.*;

/*

Pattern 1: Left-Aligned Number Triangle

For n = 5, output is:

1
12
123
1234
12345

*/

public class Pattern1{
    public static void main(String[] args){
        // take input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        // logic
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                System.out.print(j);
            }
            System.out.println();
        }

        sc.close();
    }
}
