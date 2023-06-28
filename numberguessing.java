import java.util.Random;
import java.util.Scanner;

public class numberguessing {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        Random randomGenerator = new Random();

        int lowerLimit = 1;
        int upperLimit = 100;
        int randomNumber = randomGenerator.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
        int maxAttempts = 5;
        int playerScore = 0;
        int attempts = 0;
        boolean gameOver = false;

        System.out.println("Welcome to Guess the Number!");

        while (!gameOver) {
            System.out.println("\nRound " + (playerScore + 1));
            System.out.println("Attempts remaining: " + (maxAttempts - attempts));

            System.out.print("Enter your guess (between " + lowerLimit + " and " + upperLimit + "): ");
            int playerGuess = inputScanner.nextInt();
            inputScanner.nextLine(); 

            if (playerGuess < randomNumber) {
                System.out.println("Higher!");
            } else if (playerGuess > randomNumber) {
                System.out.println("Lower!");
            } else {
                System.out.println("Congratulations! You guessed the number correctly.");
                playerScore++;
                attempts = 0;

                System.out.print("Do you want to play again? (yes/no): ");
                String playAgain = inputScanner.nextLine();
                if (!playAgain.equalsIgnoreCase("yes")) {
                    gameOver = true;
                } else {
                    randomNumber = randomGenerator.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
                }
            }

            attempts++;

            if (attempts >= maxAttempts) {
                System.out.println("Game over! You couldn't guess the number within the given attempts.");
                System.out.println("The number was: " + randomNumber);

                System.out.print("Do you want to play again? (yes/no): ");
                String playAgain = inputScanner.nextLine();
                if (!playAgain.equalsIgnoreCase("yes")) {
                    gameOver = true;
                } else {
                    playerScore = 0;
                    attempts = 0;
                    randomNumber = randomGenerator.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
                }
            }
        }

        System.out.println("\nFinal Score: " + playerScore);
        System.out.println("Thank you for playing Guess the Number!");

        inputScanner.close();
    }
}
