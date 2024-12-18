import java.util.Scanner;

/**
 * @author Qifei Wang
 * @version 1.0
 */

public class BasicIOProgram {

    /**
    *
    * @param args default arguments
    */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two whole numbers");
        System.out.println("separated by one or more spaces:");

        // read whole numbers from user.
        int number1 = sc.nextInt();
        int number2 = sc.nextInt();
        System.out.println("You entered " + number1 + " and " + number2);

        // read numbers(including decimals) from users.
        System.out.println("Next enter two numbers.");
        System.out.println("A decimal point is OK.");
        double decimalNumber1 = sc.nextDouble();
        double decimalNumber2 = sc.nextDouble();

        //print out the decimal numbers
        System.out.println("You entered " + decimalNumber1 + " and " + decimalNumber2);

        //prompt user for inputs of words seperated by spaces.
        System.out.println("Next enter two words:");
        String word1 = sc.next();
        String word2 = sc.next();
        sc.nextLine();

        System.out.println("You entered \"" + word1 + "\" and \"" + word2 + "\"");
        //promput user to input line of text
        System.out.println("Next enter a line of text:");
        String str = sc.nextLine();
        System.out.println("You entered: \"" + str + "\"");
    }
}
