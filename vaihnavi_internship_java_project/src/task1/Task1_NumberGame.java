package task1;
import java.util.Scanner;

public class Task1_NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int min = 1;
        int max = 100;
        int chances = 10;
        int final_score = 0;
        boolean play = true;

        System.out.println("Welcome to the number game program");
        System.out.println("You will have " + chances + " chances to guess the number that is between " + min + " and " + max);

        while (play) {
            int randomNumber = getRandomNumber(min, max);
            boolean guessedCorrectly = false;

            for (int i = 0; i < chances; i++) {
                System.out.print("Try number " + (i + 1) + "  : Enter your guess: ");
                int userGuess = sc.nextInt();

                if (userGuess == randomNumber) {
                    System.out.println("Hurray! you have guessed the correct number");
                    guessedCorrectly = true;
                    final_score += 1;
                    break;
                } else if (userGuess < randomNumber) {
                    System.out.println("Your guess is too low < N:  try again");
                } else {
                    System.out.println("Your guess is too high > N:  try again");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("You have run out of chances. The correct number is: " + randomNumber);
            }

            System.out.print("Would you like to play again? (yes/no): ");
            String playAgainChoice = sc.next();
            play = playAgainChoice.equalsIgnoreCase("yes");
        }

        System.out.println("Game Over! Your final_score is: " + final_score);
        sc.close();
    }

    public static int getRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }
}
