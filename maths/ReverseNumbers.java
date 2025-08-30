package maths;

import java.util.*;


public class ReverseNumbers{
    public static void main(String[] args){
        // Input
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number: ");
        int n = sc.nextInt();

        //logic
        int sign = (n < 0) ? -1 : 1;
        int absN = Math.abs(n);
        long rev = 0;

        while(absN != 0){
            int lastDigit = absN % 10;
            rev = rev * 10 + lastDigit;
            absN /= 10;
        }

        rev = rev * sign;
        if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE) {
            System.out.println("Overflow: reversed number is out of integer bounds.");
        } else {
            System.out.println("The reversed number is: " + (int)rev);
        }
    }
}