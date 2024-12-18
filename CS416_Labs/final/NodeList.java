import java.util.Scanner;
import java.util.ArrayList;

public class NodeList {

    Node head;
    Node tail;

    public class Node { // inner class
        String key;
        int data;
        Node next;
        Node prev;

        public Node(String key, int data) {
            this.key = key;
            this.data = data;
        }
    }

    // YOUR CODE HERE
    /**
     * 
     * @param key key
     * @return array list
     */

    public ArrayList<Integer> findAll(String key) {
        ArrayList<Integer> arr = new ArrayList<>();
        Node curr = head;
        while (curr != null) {
            if (curr.key.equals(key)) {
                arr.add(curr.data);
            } else {
                curr = curr.next;
            }
        }
        return arr;
    }

    public void addHead(String key, int data) {
        Node n = new Node(key, data);
        if (head == null) { // empty list
            tail = n;
        } else {
            head.prev = n;
        }
        n.next = head;

        head = n;
    }

    public void addTail(String key, int data) {
        Node n = new Node(key, data);
        if (tail == null) { // empty list
            head = n;
        }
        tail.next = n;
        n.prev = tail;
        tail = n;
    }

    public String toString() {
        String ret = "";

        Node curr = head;
        while (curr != null) {
            ret += "( " + curr.key + ", " + curr.data + " ) ";
            curr = curr.next;
        }

        return ret;
    }
}
