import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {

    private static final int MAX_ATTEMPTS = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;
        int totalScore = 0;
        int roundsPlayed = 0;

        while (playAgain) {
            roundsPlayed++;
            System.out.println("\n--- Round " + roundsPlayed + " ---");
            totalScore += playRound(scanner);

            System.out.print("Do you want to play another round? (yes/no): ");
            String response = scanner.next().trim().toLowerCase();
            playAgain = response.equals("yes");
        }

        System.out.println("\nGame Over! You played " + roundsPlayed + " rounds with a total score of " + totalScore + " attempts.");
        System.out.println("Average attempts per round: " + (double) totalScore / roundsPlayed);
        
        scanner.close();
    }

    private static int playRound(Scanner scanner) {
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1;
        int attempts = 0;

        while (attempts < MAX_ATTEMPTS) {
            System.out.print("Attempt " + (attempts + 1) + "/" + MAX_ATTEMPTS + ": Enter your guess (1-100): ");

            try {
                int userGuess = scanner.nextInt();

                if (userGuess < 1 || userGuess > 100) {
                    System.out.println("Please enter a number between 1 and 100.");
                    continue;
                }

                attempts++;

                if (userGuess < numberToGuess) {
                    System.out.println("Too low!");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    return attempts;
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // clear the invalid input
            }
        }

        System.out.println("Sorry, you've used all your attempts. The number was " + numberToGuess + ".");
        return attempts;
    }
}
