package recursion;

import java.util.*;

public class PalindromeString {
    /**
     * Recursive palindrome check
     * Time Complexity: O(N)
     * Space Complexity: O(N) recursion stack
     */
    public static boolean isPalindrome(String s, int left, int right) {
        if (left >= right) return true; // base case
        if (s.charAt(left) != s.charAt(right)) return false;
        return isPalindrome(s, left + 1, right - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = sc.nextLine();

        if (isPalindrome(s, 0, s.length() - 1)) {
            System.out.println(s + " is a palindrome.");
        } else {
            System.out.println(s + " is NOT a palindrome.");
        }
    }
}