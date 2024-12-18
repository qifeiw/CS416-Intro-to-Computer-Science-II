public class LinkedList {

    public class Node { // inner class
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
        }
    }

    public Node head;
    public Node tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    // YOUR CODE HERE
    public int countOdd() {
        int count = 0;
        Node curr = head;
        while (curr != null) {
            if (curr.data % 2 != 0) {
                count++;
            }
            curr = curr.next;
        }
        return count;
    }

    /**
     * 
     * @param val val
     */

    public void addInOrder(int val) {
        Node n = new Node(val);
        if (head == null || val < head.data) {
            addHead(val);
            return;
        }
        Node curr = head;
        while (curr.next != null && curr.next.data < val) {
            curr = curr.next;
        }
        n.next = curr.next;
        if (curr.next != null) {
            curr.next.prev = n;
        } else {
            tail = n;
        }
        curr.next = n;
        n.prev = curr;

    }

    public void addHead(int data) {
        Node n = new Node(data);
        if (head == null) { // empty list
            tail = n;
        } else {
            head.prev = n;
        }
        n.next = head;

        head = n;
    }

    public void addTail(int data) {
        Node n = new Node(data);
        if (tail == null) { // empty list
            head = n;
        } else {
            tail.next = n;
        }
        n.prev = tail;
        tail = n;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public String toString() {
        String res = "";

        Node curr = head;

        if (curr != null) {
            res += curr.data;
            curr = curr.next;
        }

        while (curr != null) {
            res += ", " + curr.data;
            curr = curr.next;
        }

        return res;
    }
}
