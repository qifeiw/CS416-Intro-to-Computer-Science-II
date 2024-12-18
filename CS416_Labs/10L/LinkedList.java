/**
 * LinkedList lab.
 * 
 * @author cs416
 * @version 1
 */
public class LinkedList {

    /**
     * Internal Node class used for the linked list.
     */
    public static class Node {
        String key;
        int value;
        Node next;
        Node prev;

        /**
         * Node Constructor.
         * 
         * @param key   The Key
         * @param value The Value
         */
        public Node(String key, int value) {
            this.key = key;
            this.value = value;
        }

        /**
         * Gets the next Node in the List.
         * 
         * @return Node
         */
        public Node getNext() {
            return next;
        }

        /**
         * Gets the previous Node in the List.
         * 
         * @return Node
         */
        public Node getPrev() {
            return prev;
        }

        /**
         * Gets the String Key.
         * 
         * @return String
         */
        public String getKey() {
            return key;
        }

        /**
         * Gets the Value.
         * 
         * @return int
         */
        public int getValue() {
            return value;
        }
    }

    private Node head;
    private Node tail;

    /**
     * The default constructor.
     */
    public LinkedList() {
        head = null;
        tail = null;
    }

    /**
     * Gets the head of the List.
     * 
     * @return Node Head Node
     */
    public Node getHead() {
        return head;
    }

    /**
     * Gets the tail of the List.
     * 
     * @return Node Tail Node
     */
    public Node getTail() {
        return tail;
    }

    /**
     * Add the key, value pair to the head of the linkedlist.
     * 
     * @param key The Key
     * @param val The Value
     */
    public void addHead(String key, int val) {
        Node n = new Node(key, val);

        if (head == null) {
            head = n;
            tail = n;
        } else {
            head.prev = n;
            n.next = head;
            head = n;
        }
    }

    /**
     * Add the key, val pair to the tail of the linkedlist.
     * 
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
            n.prev = tail;
            tail = n;
        }
    }

    /**
     * Returns the String format of the linkedlist.
     * 
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
     * 
     * @param key The key to find in the LinkedList
     * @return Node Returns the Node with the given key or null if non-existent.
     */
    public Node find(String key) {
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
     * @param n node n
     */

    public void unlinkNode(Node n) {
        if (n == null) {
            return;
        }
        // if n is head, update head
        if (n == head) {
            head = n.next;
            if (head != null) {
                head.prev = null;
            }
        }
        // if n is tail, update tail
        if (n == tail) {
            tail = n.prev;
            if (tail != null) {
                tail.next = null;
            }
        }
        // connect prev node to next, if not null
        if (n.prev != null) {
            n.prev.next = n.next;
        }
        // conect next node to prev, if not null
        if (n.next != null) {
            n.next.prev = n.prev;
        }
        n.next = null;
        n.prev = null;
    }

    /**
     * 
     * @param n      node to be inserted
     * @param before node to instert after
     */

    public void addAfter(Node n, Node before) {
        if (n == null || before == null) {
            return;
        }
        n.next = before.next;
        n.prev = before;
        before.next = n;
        if (n.next != null) {
            n.next.prev = n;
        } else {
            tail = n;
        }
    }

    /**
     * 
     * @param n node n
     * @return boolean
     */

    public boolean swapIfNeeded(Node n) {
        if (n == null || n.next == null) {
            return false;
        }
        Node next = n.next;
        if (n.key.compareTo(next.key) > 0) {
            unlinkNode(n);
            addAfter(n, next);
            return true;
        } else {
            return false;
        }
    }

    /**
     * takes no parameter and no return.
     */

    public void sort() {
        if (head == null || head.next == null) {
            return;
        }
        boolean isSwapped;
        do {
            isSwapped = false;
            Node curr = head;
            while (curr != null && curr.next != null) {
                if (swapIfNeeded(curr)) {
                    isSwapped = true;
                } else {
                    curr = curr.next; // move to next node is swap is not needed
                }
            }
        } while (isSwapped);
    }
    ///////////////////////////////////////////////////////////////

}
