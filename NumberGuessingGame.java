import java.util.*;

public class NumberGuessingGame {
    private static final int MAX_ATTEMPTS = 5;
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 100;
    private static final int MAX_ROUNDS = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int totalScore = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have selected a number between " + MIN_RANGE + " and " + MAX_RANGE + ".");
        System.out.println("You have " + MAX_ATTEMPTS + " attempts to guess it.");

        for (int round = 1; round <= MAX_ROUNDS; round++) {
            int randomNumber = random.nextInt(MAX_RANGE - MIN_RANGE + 1) + MIN_RANGE;
            int attempts = 0;
            int roundScore = 0;
            boolean hasWon = false;

            System.out.println("\nRound " + round + ":");
            while (attempts < MAX_ATTEMPTS) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else if (guess > randomNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    hasWon = true;
                    roundScore = MAX_ATTEMPTS - attempts + 1;
                    totalScore += roundScore;
                    break;
                }
            }

            if (hasWon) {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                System.out.println("Your score for this round is: " + roundScore);
            } else {
                System.out.println("Sorry, you've run out of attempts!");
                System.out.println("The number was: " + randomNumber);
            }
        }

        System.out.println("\nGame Over!");
        System.out.println("Your total score is: " + totalScore);

        scanner.close();
    }
}
