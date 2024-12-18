/**
 * @author Qifei Wang
 * @version 1
 * @param <T> t
 */

public class Queue<T> {
    private LinkedList<T> list;
    /**
     * @constructor.
     */

    public Queue() {
        list = new LinkedList<T>();
    }
    /**
     * 
     * @param t t
     */

    public void add(T t) {
        list.addTail(t);
    }
    /**
     * 
     * @return head
     */

    public T remove() {
        return list.remHead();
    }
    /**
     * 
     * @return list
     */
    
    public LinkedList<T> getList() {
        return list;
    }
    
}
