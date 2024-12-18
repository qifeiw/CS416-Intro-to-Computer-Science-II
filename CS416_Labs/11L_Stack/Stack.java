/**
 * @author Qifei Wang
 * @version 1
 */

public class Stack {
    private int[] stack = new int[10];
    private int index;

    /**
     * constructor.
     */

    public Stack() {
        this.index = -1;
    }

    /**
     * 
     * @return true if statck is empty
     */

    public boolean isEmpty() {
        if (index < 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 
     * @param value input integer
     * @return boolean
     */

    public boolean push(int value) {
        if (index < stack.length - 1) {
            stack[++index] = value;
            return true;
        } else {
            return false;
        }
    }

    /**
     * 
     * @return int
     */

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        } else {
            return stack[index--];
        }
    }

    /**
     * 
     * @return integer
     */

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        } else {
            return stack[index];
        }
    }

    /**
     * @return string format
     */

    public String toString() {
        if (isEmpty()) {
            return "";
        } else {
            StringBuilder str = new StringBuilder();
            for (int i = index; i >= 0; i--) {
                str.append(stack[i]);
                if (i > 0) {
                    str.append(", ");
                }
            }
            return str.toString();
        }
    }
    /**
     * 
     * @param args args
     */

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s);
    }
}
