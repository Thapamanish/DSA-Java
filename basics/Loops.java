package basics;

public class Loops {
    public static void main(String[] args) {

        // for loop
        System.out.println("Starting the for loop!");

        for (int i = 1; i <= 5; i++) {
            System.out.println("Current number is: " + i);
        }

        System.out.println("For loop finished!");

        // while loop
        int countdown = 5; // Initialize the counter outside the loop

        System.out.println("Starting the while loop countdown!");

        while (countdown > 0) {
            System.out.println(countdown);
            countdown--; // Decrement the counter
        }

        System.out.println("Blast off!");

    }
}
