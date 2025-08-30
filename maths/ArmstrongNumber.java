

package maths;

import java.util.*;

public class ArmstrongNumber {
    /**
     * Check if a number is an Armstrong number.
     * Time Complexity: O(d) where d = number of digits
     * Space Complexity: O(1)
     */
    public static boolean isArmstrong(int n) {
        int original = n;
        int digits = 0;
        int temp = n;

        // Count digits
        while (temp != 0) {
            digits++;
            temp /= 10;
        }

        temp = n;
        int sum = 0;
        while (temp != 0) {
            int digit = temp % 10;
            sum += Math.pow(digit, digits);
            temp /= 10;
        }

        return sum == original;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        if (isArmstrong(n)) {
            System.out.println(n + " is an Armstrong number.");
        } else {
            System.out.println(n + " is NOT an Armstrong number.");
        }
    }
}