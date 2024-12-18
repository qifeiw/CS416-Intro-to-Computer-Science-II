/**
 * @author Qifei Wang
 * @version 1
 * @param <T> t
 */

public class ArraySearch<T extends Comparable<? super T>> implements Search {
    private T[] list;

    /**
     * 
     * @param list list
     */
    // Constructor

    public ArraySearch(T[] list) {
        this.list = list;
    }

    /**
     * @return true or false
     */

    public boolean isEmpty() {
        return list.length == 0;
    }

    /**
     * @return size of the list
     */

    public int size() {
        return list.length;
    }

    /**
     * @return true if list is sorted
     */

    public boolean isSorted() {
        if (list.length < 2) {
            return true;
        }
        for (int i = 0; i < (list.length - 1); i++) {
            if (list[i].compareTo(list[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param obj object
     * @return indext int
     */

    public int index(Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int i = 0; i < list.length; i++) {
            if (obj.equals(list[i])) {
                return i;
            }
        }
        return -1;
    }

}
