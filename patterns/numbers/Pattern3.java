package patterns.numbers;

import java.util.*;

/*

Pattern 3: Inverted Number Triangle (Left-Aligned)

For n = 5, output is:

12345
1234
123
12
1

*/



public class Pattern3{
    public static void main(String[] args){
        // take input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        // logic
        for(int i = n; i >= 1; i--){
            for(int j = 1; j <= i; j++){
                System.out.print(j);
            }
            System.out.println();
        }

        sc.close();
    }
}
