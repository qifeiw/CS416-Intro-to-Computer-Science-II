import java.util.Scanner;
/**
 * @author Qifei Wang
 * @version 1
 * @param <T> type
 */

public class LinkedList<T> extends List<T> {
    private Node head;
    private Node tail;
    
    /**
     * //constructor.
     */

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }
    /**
     * 
     * @return head
     */

    public Node getHead() {
        return head;
    }
    /**
     * 
     * @return tail
     */

    public Node getTail() {
        return tail;
    }
    /**
     * @param value value
     * @return boolean
     */

    public boolean add(T value) {
        Node newNode = new Node(value);
        if (this.contains(value)) {
            return false;
        }
        addLast(newNode);
        return true;
    }
    /**
     * @param index index
     * @param value value
     */

    public void add(int index, T value) {
        Node newNode = new Node(value);
        if (index < 0 || this.contains(value)) {
            return;
        } else if (head == null || index == size()) {
            addLast(newNode);
        } else if (index == 0) {
            addFirst(newNode);
        } else {
            addAt(newNode, index);
        }
    }
    /**
     * 
     * @param newNode node
     */

    private void addFirst(Node newNode) {
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }
    /**
     * 
     * @param newNode node
     */

    private void addLast(Node newNode) {
        newNode.next = null;
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } 
    }
    /**
     * 
     * @param newNode node
     * @param index index
     */

    private void addAt(Node newNode, int index) {
        Node nodeRef = head;
        for (int i = 1; i < index; i++) {
            nodeRef = nodeRef.next;
        }
        newNode.next = nodeRef.next;
        nodeRef.next = newNode;
        newNode.prev = nodeRef;
        nodeRef.next.prev = newNode;
    }    
    /**
     * removes all the elements from the list.
     */

    public void clear() {
        this.head = null;
        this.tail = null;
    }
    /**
     * @param o o
     * @return boolean true or false
     */

    public boolean contains(Object o) {
        Node n = head;
        while (n != null) {
            if (n.value.equals(o)) {
                return true;
            }
            n = n.next;
        }
        return false;
    }
    /**
     * @param index index
     * @return T t
     */

    public T get(int index) {
        Node n = head;
        int count = 0;
        while (n != null) {
            if (count == index) {
                return n.value;
            }
            n = n.next;
            count++;
        }
        return null;

    }
    /**
     * @param o o
     * @return T t
     */

    public T get(Object o) {
        Node n = this.head;
        while (n != null) {
            if (n.value.equals(o)) {
                return n.value;
            }
            n = n.next;
        }
        return null;
    }
    /**
     * @param index index
     * @return T t
     */

    public T remove(int index) {
        T result;
        if (index == 0) {
            result = removeFirst();
        } else if (index == size() - 1) {
            result = removeLast();
        } else {
            Node n = getNode(index);
            result = n.value;
            removeAny(n);
        }
        return result;
    }
    /**
     * @param index index
     * @return Node
     *
     */

    private Node getNode(int index) {
        Node n = head;
        int count = 0;
        while (n != null) {
            if (count == index) {
                return n;
            }
            n = n.next;
            count++;
        }
        return null;
    }
    /**
     * @return true if is empty
     */

    public boolean isEmpty() {
        return size() == 0;
    }
    /**
     * @param o o 
     * @return true if removed
     */

    public boolean remove(Object o) {
        if (o.equals(head.value)) {
            removeFirst();
            return true;
        }
        if (o.equals(tail.value)) {
            removeLast();
            return true;
        }
        for (Node curr = this.head; curr != null; curr = curr.next) {
            if (curr.value.equals(o)) {
                removeAny(curr);
                return true;
            }
        }
        return false;
    }
    /**
     * 
     * @return the node removed
     */

    private T removeFirst() {
        Node result;
        if (size() == 1) {
            result = head;
            head = null;
            tail = null;
        } else {
            result = head;
            head = head.next;
            head.prev = null;
        }
        return result.value;
    }
    /**
     * 
     * @return node removed
     */

    private T removeLast() {
        Node result;
        result = tail;
        tail = tail.prev;
        tail.next = null;
        return result.value;
    }
    /**
     * 
     * @param n node to be removed
     */

    private void removeAny(Node n) {
        Node prev = n.prev;
        Node next = n.next;
        prev.next = next;
        next.prev = prev;
    }
    /**
     * @return int size of the linkedlist
     */

    public int size() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
    /**
     * @return String string
     */

    public String toString() {
        Node temp = head;
        StringBuilder listString = new StringBuilder();
        listString.append("[");
        while (temp != null) {
            listString.append(temp.value);
            if (temp.next != null) {
                listString.append(", ");
            }
            temp = temp.next;
        }
        listString.append("]");
        return listString.toString();
    }
    /**
     * 
     * @param args args
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedList<String> l = new LinkedList<String>();

        String input = sc.nextLine();
        while (!input.equals("x")) {
            String[] tokens = input.split(" ");
            if (tokens[0].equals("a")) { // add(T value)
                String value = tokens[1];

                l.add(value);
                System.out.println(l);
            } else if (tokens[0].equals("A")) { // add(int index, T value)
                int index = Integer.parseInt(tokens[1]);
                String value = tokens[2];
                
                l.add(index, value);
                System.out.println(l);
            } else if (tokens[0].equals("c")) { // contains(Object o)
                String value = tokens[1];

                System.out.println(l.contains(value));
            } else if (tokens[0].equals("C")) { // clear()
                l.clear();
                System.out.println(l);
            } else if (tokens[0].equals("r")) { // remove(Object o)
                String value = tokens[1];

                l.remove(value);
                System.out.println(l);
            } else if (tokens[0].equals("R")) { // remove(int index)
                int index = Integer.parseInt(tokens[1]);

                l.remove(index);
                System.out.println(l);
            } else if (tokens[0].equals("g")) { // get(int index)
                int index = Integer.parseInt(tokens[1]);
                
                System.out.println(l.get(index));
            } else if (tokens[0].equals("e")) { // isEmpty()
                System.out.println(l.isEmpty());
            } else if (tokens[0].equals("s")) { // size()
                System.out.println(l.size());
            }

            System.out.println("------------------");
            input = sc.nextLine();
            sc.close();
        }
    }
}
