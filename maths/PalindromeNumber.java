package maths;

import java.util.*;

public class PalindromeNumber {
    public static void main(String[] args) {
        // Input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = sc.nextInt();

        // Handle negatives (negative numbers cannot be palindrome in most interview interpretations)
        if (n < 0) {
            System.out.println(n + " is NOT a palindrome number.");
            return;
        }

        int original = n;
        int temp = n;
        long rev = 0;

        while (temp != 0) {
            int lastDigit = temp % 10;
            rev = rev * 10 + lastDigit;
            temp /= 10;
        }

        if (rev == original) {
            System.out.println(original + " is a palindrome number.");
        } else {
            System.out.println(original + " is NOT a palindrome number.");
        }
    }
}