import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int attemptsLimit = 10;
        int rounds = 0;
        int totalAttempts = 0;

        boolean playAgain = true;

        while (playAgain) {
            int targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("Guess the number between " + lowerBound + " and " + upperBound);

            while (attempts < attemptsLimit) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == targetNumber) {
                    guessedCorrectly = true;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (guessedCorrectly) {
                System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                totalAttempts += attempts;
            } else {
                System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was: " + targetNumber);
            }

            rounds++;

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            playAgain = playAgainInput.equals("yes");

            if (playAgain) {
                System.out.println("Let's play again!");
            } else {
                System.out.println("Thanks for playing! Your total score is based on the total attempts: " + totalAttempts);
                System.out.println("You played " + rounds + " rounds.");
            }
        }

        scanner.close();
    }
}