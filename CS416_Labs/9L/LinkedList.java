
/**
* LinkedList lab.
* @author Qifei Wang
* @version 1, Spring 2024
*/
public class LinkedList {

    /**
    * Internal Node class used for the linked list.
    */
    public class Node {
        String key;
        int value;
        Node next;

        /**
        * Node Constructor.
        * @param key The Key
        * @param value The Value
        */
        public Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node head;
    private Node tail;

    /**
    *  The default constructor.
    */
    public LinkedList() {
        head = null;
        tail = null;
    }

    /**
    * Add the key, value pair to the head of the linkedlist.
    * @param key The Key
    * @param val The Value
    *
    */
    public void addHead(String key, int val) {
        Node n = new Node(key, val);

        if (head == null) {
            head = n;
            tail = n;
        } else {
            n.next = head;
            head = n;
        }
    }

    /**
    * Add the key, val pair to the tail of the linkedlist.
    * @param key The Key
    * @param val The Value
    */
    public void addTail(String key, int val) {
        Node n = new Node(key, val);

        if (tail == null) {
            head = n;
            tail = n;
        } else {
            tail.next = n;
            tail = n;
        }
    }

    /**
    * Returns the String format of the linkedlist.
    * @return String The String format.
    */
    public String toString() {
        String ret = "";

        Node curr = head;

        while (curr != null) {
            if (curr.next != null) {
                ret += curr.key + ":" + curr.value + ", ";
            } else {
                ret += curr.key + ":" + curr.value;
            }

            curr = curr.next;
        }

        return ret;
    }

    /**
    * Locate the Node in the linkedlist with the given key.
    * @param key  The key to find in the LinkedList
    * @return Node Returns the Node with the given key or null if non-existent.
    */
    private Node find(String key) {
        Node curr = head;

        while (curr != null) {
            if (curr.key.equals(key)) {
                return curr;
            }

            curr = curr.next;
        }

        return null;
    }


    //////////////////////// YOUR CODE HERE ////////////////////////
    /**
     * 
     * @param list input LinkedList
     * @return average
     */

    public static double average(LinkedList list) {
        double sum = 0;
        double count = 0;
        Node curr = list.head;
        while (curr != null) {
            count++;
            sum += curr.value;
            curr = curr.next;
        }
        return sum / count;
    }
    /**
     * 
     * @param list LinkedList
     * @return boolean
     */

    public static boolean ordered(LinkedList list) {
        Node curr = list.head;
        while (curr.next != null) {
            if (curr.key.compareTo(curr.next.key) > 0) {
                return false;
            }
            curr = curr.next;
        }
        return true;
    }
    /**
     * 
     * @param list list
     * @return reversed linked list
     */

    public static LinkedList reversed(LinkedList list) {
        LinkedList ret = new LinkedList();
        Node curr = list.head;
        while (curr != null) {
            ret.addHead(curr.key, curr.value);
            curr = curr.next;
        }
        return ret;
    }
    /**
     * 
     * @param list list
     * @return new linked list
     */
    
    public static LinkedList compressList(LinkedList list) {
        LinkedList ret = new LinkedList();
        Node curr = list.head;
        while (curr != null) {
            Node found = ret.find(curr.key);
            if (found == null) {
                ret.addTail(curr.key, curr.value);
            } else {
                found.value += curr.value;
            }
            curr = curr.next;
        }
        return ret;
    }


    ///////////////////////////////////////////////////////////////

}
