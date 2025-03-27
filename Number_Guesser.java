/*
 * 27th March 2025
 * 
 * Number Guesser Game
 * 
 * 9:39 AM:
 * This is the first version
 * Future version features could have:
 * (1) Difficulties (easy, hard and god-mode)
 * Easy - 10 tries, 0-100
 * Hard - 5 tries, 0-200
 * GodMode - 3 tries, 0-1000
 * 
 * 
 * 9:56 AM:
 * I've added the difficulty levels
 * have a choice to play again
 * I've added a play again feature
 * I've added a switch case for the difficulty levels
 * Added more levels of difficulty (5 levels):
 * Easy (10 tries, range 0-100)
 * Normal (10 tries, range 0-200)
 * Mid (5 tries, range 0-200)
 * Hard (5 tries, range 0-500)
 * God-Mode (3 tries, range 0-1000)
 * Added a playGame method to handle the game logic
 * Added a playAgain boolean to handle the play again feature
 * Added a while loop to handle the play again feature
 * Added a switch case to handle the difficulty levels
 * Added a default case for invalid choice
 */

import java.util.*;

public class Number_Guesser {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to Random Guessing game!");
        System.out.println("Choose a difficulty level: ");
        System.out.println("0. Mini (3 try, range 0-20)");
        System.out.println("1. Easy (10 tries, range 0-100)");
        System.out.println("2. Normal (10 tries, range 0-200)");
        System.out.println("3. Mid (5 tries, range 0-200)");
        System.out.println("4. Hard (5 tries, range 0-500)");
        System.out.println("5. God-Mode (3 tries, range 0-1000)");

        int choice = s.nextInt();

        boolean playAgain = true;

        while (playAgain) {
            switch (choice) {
            case 0 -> playGame(3, 20);
            case 1 -> playGame(10, 100);
            case 2 -> playGame(10, 200);
            case 3 -> playGame(5, 200);
            case 4 -> playGame(5, 500);
            case 5 -> playGame(3, 1000);
            default -> {
                System.out.println("Invalid choice. Exiting game.");
                playAgain = false;
                return;
                }
            }

            System.out.println("Do you want to play again? (yes/no)");
            String response = s.next().toLowerCase();
            if (response.equals("yes")) {
            System.out.println("Choose a difficulty level: ");
            System.out.println("0. Mini (3 try, range 0-20)");
            System.out.println("1. Easy (10 tries, range 0-100)");
            System.out.println("2. Normal (10 tries, range 0-200)");
            System.out.println("3. Mid (5 tries, range 0-200)");
            System.out.println("4. Hard (5 tries, range 0-500)");
            System.out.println("5. God-Mode (3 tries, range 0-1000)");
            choice = s.nextInt();
            } else {
            playAgain = false;
            System.out.println("Thanks for playing! Goodbye!");
            }
        }
    }

    public static void playGame(int tries, int range) {
        int secretNum, guess, myInputNum;
        boolean guessed = false;
        Scanner s = new Scanner(System.in);
        guess = tries;
        Random random = new Random();
        secretNum = random.nextInt(range + 1);
        System.out.println("You have " + guess + " number of tries.");
        System.out.println("Make a guess!");

        while (guess > 0 && !guessed) {
            myInputNum = s.nextInt();

            if (myInputNum > secretNum) {
                System.out.println("Guess lower!");
                guess--;
                System.out.println("You now have " + guess + " tries left.");
            } else if (myInputNum < secretNum) {
                System.out.println("Guess higher!");
                guess--;
                System.out.println("You now have " + guess + " tries left.");
            } else {
                System.out.println("Hooray! You got it!!!!");
                guessed = true;
            }
        }

        if (guess == 0 && !guessed) {
            System.out.println("You Lose :(");
            System.out.println("The secret number was: " + secretNum);
        }
    }
}