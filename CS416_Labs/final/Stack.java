import java.util.LinkedHashSet;

/**
 * @author Qifei Wang
 * @version 1
 * @param <T> t
 */

public class Stack<T> {
    private LinkedList<T> list;
    
    /**
     * constructor.
     */

    public Stack() {
        list = new LinkedList<>();
    }
    /**
     * 
     * @param t input
     */

    public void push(T t) {
        list.addHead(t);
    }
    /**
     * 
     * @return the head
     */

    public T pop() {
        return list.remHead();
    }
    /**
     * 
     * @return the list
     */
    
    public LinkedList<T> getList() {
        return list;
    }

}