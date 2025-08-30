package maths;

import java.util.*;


public class CountDigits{
    public static void main(String[] args){
        // Input
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number: ");
        int n = sc.nextInt();

        //logic
        int count = 0;

        // handles 0 as a special case
        if(n == 0){
            count++; 
        } else{
            while(n != 0){
                n = n / 10; // remove last digit
                count++;
            }
        }

        System.out.println("Total no of digits: " + count);
    }
}