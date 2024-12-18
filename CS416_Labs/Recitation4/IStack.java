/**
 * @author Qifei Wang
 * @version 1
 * @param <T> Tree
 */

public interface IStack<T> {
    // adds the T parameter to the top  of the stack
    public void push(T val);

    // removes and returns the top elements of the stack
    //throws an EmptyStackException if there are 0 elements
    public T pop();

    // returns the top elements of the stack
    //throws an EmptyStackException if there are 0 elements
    public T peek();

    //returns the current number of elements stored in the Stack
    public int size();
}