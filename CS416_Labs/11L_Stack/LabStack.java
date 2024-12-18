import java.util.ArrayList;

/**
 * @author Qifei Wang
 * @version 1
 */

public class LabStack {
    /**
     * 
     * @param st stack
     * @param n  n items to be poped
     * @return attay list
     */

    public static ArrayList<Integer> popN(Stack st, int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n && !st.isEmpty(); i++) {
            list.add(st.pop());
        }
        return list;
    }

    /**
     * 
     * @param st stack
     * @return array list
     */

    public static ArrayList<Integer> popAll(Stack st) {
        ArrayList<Integer> list = new ArrayList<>();
        while (!st.isEmpty()) {
            list.add(st.pop());
        }
        return list;
    }

    /**
     * 
     * @param arr array
     * @return array
     */

    public static int[] reverse(int[] arr) {
        Stack st = new Stack();
        for (int i : arr) {
            st.push(i);
        }
        int n = arr.length;
        int[] reversed = new int[n];
        for (int i = 0; i < n; i++) {
            reversed[i] = st.pop();
        }
        return reversed;
    }
}
