import java.util.Random;
import java.util.Scanner;

public class NumberGuessing {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Generate random number between 1 and 100
            Random random = new Random();
            int targetNumber = random.nextInt(100) + 1;
            int attempts = 0;
            boolean hasGuessedCorrectly = false;
            
            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I'm thinking of a number between 1 and 100.");
            
            // Main game loop
            while (!hasGuessedCorrectly) {
                System.out.print("\nEnter your guess: ");
                int guess = scanner.nextInt();
                attempts++;
                
                // Check the guess
                if (guess == targetNumber) {
                    hasGuessedCorrectly = true;
                    System.out.println("\nCongratulations! You've guessed the number!");
                    System.out.println("It took you " + attempts + " attempts.");
                } else if (guess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }
        }
    }
}

