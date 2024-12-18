import java.util.Scanner;

/**
 * @author Qifei Wang
 * @version 1 CS416 Quiz1 programming
 */

public class NGuesses {
    /**
     * 
     * @param args inputs
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfGuess = Integer.parseInt(args[0]);
        int pickedNum = Integer.parseInt(args[1]);
        String prize = args[2];
        int guess = 0;
        boolean hasWon = false; // keep track if player has won

        for (int i = 0; i < numOfGuess; i++) {
            System.out.println("Enter a guess: ");
            guess = sc.nextInt();
            if (guess < pickedNum) {
                System.out.println("Too low");
            } else if (guess > pickedNum) {
                System.out.println("Too high");
            } else {
                System.out.println("That's the right number");
                System.out.println("Congratulations,  you won a " + prize + "!");
                hasWon = true;
                break;
            }
        }
        if (!hasWon) {
            System.out.println("Sorry you didn't win, the number was " + pickedNum);
        }
    }
}