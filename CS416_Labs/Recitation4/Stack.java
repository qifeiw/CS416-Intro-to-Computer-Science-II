import java.util.EmptyStackException;
/**
 * @author Qifei Wang
 * @version 1
 * @param <T> parameter
 */

public class Stack<T> implements IStack<T> {
    //inner class to represent a Node in the Stack
    /**
     * inner class node.
     */

    private class Node {
        T val;
        Node next;

    }
    private Node head;
    private int size;
    // constructor

    public Stack() {
        head = null;
        size = 0;
    }
    /**
     * @param T val of type T
     */

    public void push(T val) {
        Node n = new Node();
        n.val = val;
        n.next = head;
        head = n;
        size++;
    }
    /**
     * @return T
     */

    public T pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        Node n = head;
        head = n.next;
        size--;
        return n.val;
    }

    public T peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        Node n = head;
        return n.val;
    }
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        assert(s.size() == 1);
        assert(s.peek() == 1);

        s.push(1);
        s.push(2);

        assert(s.peek() == 2);
        assert(s.size() == 3);

        assert(s.pop() == 2);
        assert(s.pop() == 1);
        assert(s.pop() == 1);
        assert(s.size() == 0);

        try{
            s.peek();
        } catch( EmptyStackException e) {
            System.out.println("Success");
        }

        try{
            s.pop();
        } catch( EmptyStackException e) {
            System.out.println("Success");
        }
    }
}

