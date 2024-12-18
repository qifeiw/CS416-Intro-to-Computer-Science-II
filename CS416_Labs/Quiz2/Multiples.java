/**
 * @author Qifei Wang
 * @version 1
 */

public class Multiples implements Sequence {

    private int num;
    private int counter;

    // YOUR CODE HERE
    /**
     * 
     * @param val num
     */

    public Multiples(int val) {
        this.num = val;
        this.counter = 1;
    }

    /**
     * @return int
     */

    public int nextVal() {
        int result = num * counter;
        counter++;
        return result;
    }

    /**
     * 
     */

    public void reset() {
        counter = 1;
    }

}
