import java.util.Scanner;

/**
 * @author Qifei Wang
 * @version 1
 * @param <T> T
 */

public class LinkedList<T> extends List<T> {
    private Node head;
    private Node tail;

    // constructor.
    /**
     * 
     */
    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    /**
     * 
     * @return the head of the list
     */

    public Node getHead() {
        return head;
    }

    /**
     * 
     * @return return the tail of the list
     */

    public Node getTail() {
        return tail;
    }
    /**
     * 
     * @param newNode node to be added
     */

    private void addFirst(Node newNode) {
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        
    }
    /**
     * 
     * @param newNode node to be added at last
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
     * @param newNode node to be added
     * @param index index
     */

    private void addAt(Node newNode, int index) {
        Node nRef = head;
        for (int i = 1; i < index; i++) {
            nRef = nRef.next;
        }

        newNode.next = nRef.next;
        nRef.next = newNode;
        newNode.prev = nRef;
        nRef.next.prev = newNode;
    }

    /**
     * Appends the specified value to the end of this list. Should not add duplicate
     * items
     * to the list. Returns true if added, false otherwise
     * @param value Value
     * @return true or false
     *
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
        }
        if (head == null || index == size()) {
            addLast(newNode);
        } else if (index == 0) {
            addFirst(newNode);
        } else {
            addAt(newNode, index);
        }

    }

    /**
     * @return string
     */

    public String toString() {
        Node temp = head;
        StringBuilder str = new StringBuilder();
        str.append("[");
        while (temp != null) {
            str.append(temp.value);
            if (temp.next != null) {
                str.append(", ");
            }
            temp = temp.next;
        }
        str.append("]");
        return str.toString();
    }

    /**
     * removes all the elements from the list.
     */

    public void clear() {
        this.head = null;
        this.tail = null;
    }
    /**
     * Returns the element at the specified position in this list. Should return null if the index is invalid.
     * @param index index
     * @return T T
     */

    public T get(int index) {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            if (count == index) {
                return temp.value;
            }
            temp = temp.next;
            count++;
        }
        return null;
    }
    /**
     * @param o o
     * @return T t
     */

    public T get(Object o) {
        Node n = head;
        while (n != null) {
            if (n.value.equals(o)) {
                return n.value;
            }
            n = n.next;
        }
        return null;
    }
    /**
     * @param o object
     * @return true or false
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
     * @return int size of the list
     */

    public int size() {
        int result = 0;
        Node temp = head;
        while (temp != null) {
            result++;
            temp = temp.next;
        }
        return result;
    }
    /**
     * @return true if list is empty
     */

    public boolean isEmpty() {
        return size() == 0;
    }
    /**
     * //Removes the element at the specified position in this list. 
     * Returns the element from the list or null if index is invalid.
     * @param index index 
     * @return T T
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
     * Removes the first occurrence of the specified element from this list, if it is present.
     *  If this list does not contain the element, it is unchanged. 
     * Returns true if this list contained the specified element, false otherwise
     * @param o o
     * @return true or false
     */

    public boolean remove(Object o) {
        if (o.equals(head.value)) {
            removeFirst();
            return true;
        } else if (o.equals(tail.value)) {
            removeLast();
            return true;
        } else {
            for (Node curr = head; curr != null; curr = curr.next) {
                if (curr.value.equals(o)) {
                    removeAny(curr);
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * 
     * @return T
     */

    private T removeFirst() {
        if (head == null) return null; // List is empty.
    
        Node temp = head;
        T value = head.value;
        head = head.next;
    
        if (head == null) {
            tail = null; // List had only one item.
        } else {
            head.prev = null;
        }
    
        return value;
    }
    private T removeLast() {
        if (tail == null) return null; // List is empty.
    
        Node temp = tail;
        T value = tail.value;
        tail = tail.prev;
    
        if (tail == null) {
            head = null; // List had only one item.
        } else {
            tail.next = null;
        }
    
        return value;
    }
    private Node getNode(int index) {
        Node current = head;
        int count = 0;
        while (current != null && count < index) {
            current = current.next;
            count++;
        }
        return current; // This will return null if index is out of bounds.
    }
    private void removeAny(Node node) {
        if (node == null) return; // or throw a new IllegalArgumentException("Node cannot be null");
    
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
    
        if (node == head) {
            head = node.next;
        }
        if (node == tail) {
            tail = node.prev;
        }
    }
    /**
    * Main method.
    * @param args Command line arguments.
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
        }

        sc.close();
    }


}
