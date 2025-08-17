import java.util.Scanner;
import java.util.Random;
public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int numberToGuess = rand.nextInt(100) + 1;
        int userGuess;
        int attempts = 0;
        int maxAttempts = 5;
        System.out.println(" Welcome to Number Guessing Game!");
        System.out.println("I have chosen a number between 1 and 100.");
        System.out.println("You have " + maxAttempts + " attempts to guess it. Good luck!");
        while (attempts < maxAttempts) {
            System.out.print("\nEnter your guess: ");
            userGuess = sc.nextInt();
            attempts++;
            if (userGuess < numberToGuess) {
                System.out.println("Too low!");
            } else if (userGuess > numberToGuess) {
                System.out.println("Too high!");
            } else {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                return;
            }
            System.out.println("Attempts left: " + (maxAttempts - attempts));
        }
        System.out.println("\n Game Over! You've used all " + maxAttempts + " attempts.");
        System.out.println("The correct number was: " + numberToGuess);
        sc.close();
    }
}
