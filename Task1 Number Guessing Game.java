import java.util.Random;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalScore = 0;
        int roundsWon = 0;

        while (playAgain) {
            int targetNumber = random.nextInt(100) + 1;
            int attemptsLeft = 10;
            boolean hasGuessedCorrectly = false;

            System.out.println("Guess the number between 1 and 100. You have 10 attempts.");

            while (attemptsLeft > 0) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attemptsLeft--;

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You've guessed the correct number.");
                    totalScore += attemptsLeft; 
                    roundsWon++;
                    hasGuessedCorrectly = true;
                    break;
                } else if (userGuess > targetNumber) {
                    System.out.println("Your guess is too high.");
                } else {
                    System.out.println("Your guess is too low.");
                }

                System.out.println("Attempts left: " + attemptsLeft);
            }

            if (!hasGuessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts. The correct number was: " + targetNumber);
            }

            System.out.println("Total score: " + totalScore);
            System.out.println("Rounds won: " + roundsWon);

            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("Thanks for playing! Your final score is: " + totalScore + ", and you won " + roundsWon + " rounds.");
        scanner.close();
    }
}
