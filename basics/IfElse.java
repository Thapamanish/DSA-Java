package Basics;

public class IfElse {
    public static void main(String[] args) {
        int score = 85;
        char grade; // We declare the variable but don't initialize it yet

        if (score >= 90) {
            grade = 'A';
        } else if (score >= 80) {
            grade = 'B';
        } else if (score >= 70) {
            grade = 'C';
        } else {
            grade = 'D';
        }

        System.out.println("Your score is: " + score);
        System.out.println("Your calculated grade is: " + grade);
    }
}