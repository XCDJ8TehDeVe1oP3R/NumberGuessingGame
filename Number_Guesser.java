import java.util.*;

public class Number_Guesser {

    public static void main( String[] args) {
        int secretNum, guess, myInputNum;
        boolean guessed = false;
        Scanner s = new Scanner(System.in);
        guess = 10;
        Random random = new Random();
        secretNum = random.nextInt(0, 100);
        System.out.println("Welcome to Random Guessing game!");
        System.out.println("You have " + guess + " number of tries.");


        while (guess > 0 || guessed == false) { 
            System.out.println("Make a guess!");
            myInputNum = s.nextInt();

            if(myInputNum > secretNum) {
                System.out.println("Guess lower!");
                guess--;
                System.out.println("You now have " + guess + " tries left.");
            } else if(myInputNum < secretNum) {
                System.out.println("Guess higher!");
                guess--;
                System.out.println("You now have " + guess + " tries left.");
            } else if(myInputNum == secretNum) {
                System.out.println("Hooray! You got it!!!!");
                guessed = true;
            }
        }

        if(guess == 0) {
            System.out.println("You Loose :(");
        }

    }
}