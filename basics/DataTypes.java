package basics;

public class DataTypes {
    public static void main(String[] args) {
        // Integer for whole numbers
        int gamesPlayed = 10;

        // Double for decimal numbers
        double winPercentage = 75.5;

        // Char for a single character
        char rank = 'S';

        // Boolean for true/false values
        boolean isProPlayer = true;

        // Now, let's print them out!
        System.out.println("Games Played: " + gamesPlayed);
        System.out.println("Win Percentage: " + winPercentage);
        System.out.println("Player Rank: " + rank);
        System.out.println("Is a pro player? " + isProPlayer);

        // You can also perform calculations
        int wins = 8;
        int losses = 2;
        int totalGames = wins + losses; // The '+' operator adds numbers
        System.out.println("Total calculated games: " + totalGames);
    }
}