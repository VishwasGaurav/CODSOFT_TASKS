import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        int round = 1;
        char playAgain;

        System.out.println("====================================");
        System.out.println("       NUMBER GUESSING GAME");
        System.out.println("====================================");

        do {

            int number = random.nextInt(100) + 1;
            int attempts = 7;
            boolean guessed = false;

            System.out.println("\nRound " + round);
            System.out.println("Guess a number between 1 and 100");
            System.out.println("You have " + attempts + " attempts.");

            while (attempts > 0) {

                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();

                if (guess == number) {
                    System.out.println("Congratulations! You guessed correctly.");
                    guessed = true;
                    totalScore++;
                    break;
                }
                else if (guess < number) {
                    System.out.println("Too Low!");
                }
                else {
                    System.out.println("Too High!");
                }

                attempts--;
                System.out.println("Attempts Left: " + attempts);
            }

            if (!guessed) {
                System.out.println("You Lost!");
                System.out.println("Correct Number was: " + number);
            }

            System.out.println("Current Score: " + totalScore);

            System.out.print("\nDo you want to play another round? (Y/N): ");
            playAgain = sc.next().charAt(0);

            round++;

        } while (playAgain == 'Y' || playAgain == 'y');

        System.out.println("\n====================================");
        System.out.println("Game Over");
        System.out.println("Total Score: " + totalScore);
        System.out.println("Thank You for Playing!");
        System.out.println("====================================");

        sc.close();
    }
}