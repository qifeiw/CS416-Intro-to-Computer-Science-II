//import java.util.*;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author Qifei Wang
 * @version 1
 */

public class Postfix {
    /**
     * 
     * @param str str
     * @return char
     */

    public static char checkValidOperator(String str) {
        switch (str) {
            case "+":
                return '+';
            case "-":
                return '-';
            case "*":
                return '*';
            case "/":
                return '/';
            default:
                return '?';
        }

    }
    /**
     * 
     * @param stack stack
     * @param operator operator
     * @return result
     */

    public static int execute(Stack<Integer> stack, char operator) {
        int rightOperator = stack.pop();
        int leftOperator = stack.pop();
        int result = 0;
        switch (operator) {
            case '+':
                result = leftOperator + rightOperator;
                break;
            case '-':
                result = leftOperator - rightOperator;
                break;
            case '*':
                result = leftOperator * rightOperator;
                break;
            case '/':
                result = leftOperator / rightOperator;
                break;                
        }
        stack.push(result);
        return result;
    }
    /**
     * 
     * @param expr expression
     * @return a number
     */

    public static Number evaluateExpression(String expr) {
        String tooFewOperands = "Too few operands";
        String unknownOperator = "Unknown operator";
        String tooManyOperands = "Too many operands";
        Stack<Integer> stack = new Stack<>();
        String errMsg = null;
        Scanner scanner = new Scanner(expr);
        while (scanner.hasNext() && errMsg == null) {
            if (scanner.hasNextInt()) {
                int operand = scanner.nextInt();
                System.out.println("Operand read: " + operand);
                stack.push(operand);
            } else {
                String token = scanner.next();
                char operator = checkValidOperator(token);
                if (operator != '?') {
                    System.out.println("Operator read: " + operator);
                    if (stack.size() >= 2) {
                        execute(stack, operator);
                    } else {
                        errMsg = tooFewOperands;
                    }
                } else {
                    errMsg = unknownOperator + ": " + token;
                }
            }
            System.out.println("------ Stack state -----");
            System.out.println(stack);
        }
        if (errMsg != null) {
            System.out.println("Failed evaluation of |" + expr + "|\n" + errMsg);
            return null;
        }
        if (stack.size() > 1) {
            System.out.println("Failed evaluation of |" + expr + "|\n" + tooManyOperands + "." + stack.toString());
            return null;
        }
        return stack.pop();
    }
    /**
     * 
     * @param args args
     */

    public static void main(String[] args) {
        //System.out.println(checkValidOperator("+"));
        //System.out.println(checkValidOperator("!"));
        //System.out.println(checkValidOperator("--"));
        //Stack<Integer> s = new Stack<>();
        //s.push(2);
        //s.push(2);

        //char operator = '+';
        //execute(s, operator);

        //System.out.println(s);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a postfix expression");
        String input = scanner.nextLine();
        Number result = evaluateExpression(input);
        if (result != null) {
            System.out.println("Expression: " + input + " --> " + result);
        }
    }
}