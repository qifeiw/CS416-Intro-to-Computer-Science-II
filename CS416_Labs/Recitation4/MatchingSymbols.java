import java.util.Scanner;
import java.util.Stack;
import java.util.EmptyStackException;
/**
 * 
 */
public class MatchingSymbols {
    private static final String OPEN_SYMBOLS = "({[<";
    private static final String CLOSE_SYMBOLS = ")}]>";
    private static boolean isValid(String arg) {
        Stack<Character> stack = new Stack<>();
        for (char c:arg.toCharArray()) {
            if (OPEN_SYMBOLS.indexOf(c) != -1) {
                stack.push(c);
            } else if (CLOSE_SYMBOLS.indexOf(c) != -1) {
                if (stack.isEmpty()){
                    return false;
                }
                char opposite;
                switch (c) {
                    case ')':
                        opposite = '(';
                        break;
                    case '}':
                        opposite = '{';
                        break;
                    case ']':
                        opposite = '[';
                        break;
                    case '>':
                        opposite = '<';
                        break;
                    default:
                        return false;

                }
                if (stack.peek() != opposite) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("input: ");
        String input = scan.nextLine();
        if (isValid(input)) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
        scan.close();

    }
}
