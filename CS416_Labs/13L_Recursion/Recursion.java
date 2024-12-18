/**
 * @author Qifei Wang
 * @version 1
 */

public class Recursion {
    /**
     * 
     * @param input String input
     * @return yes or no
     */
    public static boolean isPalindrome(String input) {
        int n = input.length();
        if (n == 1 || n == 0) {
            return true;
        }
        if (input.charAt(0) != input.charAt(n - 1)) {
            return false;
        }
        return isPalindrome(input.substring(1, n - 1));
    }

    /**
     * 
     * @param input  string
     * @param letter count number of letter in string
     * @return number of count
     */

    public static int countLetter(String input, char letter) {
        int n = input.length();
        if (n == 0) {
            return 0;
        }
        if (input.charAt(0) != letter) {
            return countLetter(input.substring(1), letter);
        } else {
            return 1 + countLetter(input.substring(1), letter);
        }
    }

    /**
     * 
     * @param list array list
     * @param n    the portion of array to be tested
     * @return max value in the arrray list
     */

    public static int maxValue(int[] list, int n) {
        if (n == 1) {
            return list[0];
        }
        return Math.max(list[n - 1], maxValue(list, n - 1));
    }

    /**
     * 
     * @param argv input
     */
    // My own test main method
    
    public static void main(String[] argv) {
        boolean result = isPalindrome("madamimadam");
        System.out.println(result);
        //String input = "I like to eat apples and banana.";
        //char letter = 'a';
        //int result = countLetter(input, letter);
        //System.out.println(result);
        //int[] list = {1, 3, 5, 7, 9, 10};
        //int n = 6;
        //int result = maxValue(list, n);
        //System.out.println(result);
    }
     

}