import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Qifei Wang
 * @version 1
 * @param <T> t
 */
@SuppressWarnings("rawtypes")
public class BST<T extends Comparable> implements Tree<T> {
    private Node root;
    private int size;

    /**
     * Inner class.
     */

    public class Node implements Tree.Node<T> {

        private Node left;
        private Node right;
        private Node parent;
        private T value;
        /**
         * 
         * @param value value
         */

        public Node(T value) {

            this.value = value;
        }
        /**
         * @param value value
         */

        public void setValue(T value) {
            this.value = value;
        }
        /**
         * @return T t
         */

        public T getValue() {
            return value;
        }
        /**
         * 
         * @return left child
         */

        public Node getLeft() {
            return left;
        }
        /**
         * 
         * @return right
         */

        public Node getRight() {
            return right;
        }
        /**
         * 
         * @return parent
         */

        public Node getParent() {
            return parent;
        }
    }
    /**
     * constructor.
     */

    public BST() {

    }
    /**
     * 
     * @return root
     */

    public Node getRoot() {
        return root;
    }
    /**
     * @param value value to be added
     * @return true after adding value
     */

    public boolean add(T value) {
        if (root == null) {
            root = new Node(value);
            size++;
            return true;
        }

        return add(root, value);
    }
    /**
     * 
     * @param n n
     * @param value value
     * @return true or false
     */

    @SuppressWarnings("unchecked")
    public boolean add(Node n, T value) {
        if (n.value.equals(value)) {
            return false;
        } else if (n.value.compareTo(value) > 0) {
            if (n.left == null) {
                n.left = new Node(value);
                n.left.parent = n;
                size++;
                return true;
            } else {
                return add(n.left, value);
            }
        } else {
            if (n.right == null) {
                n.right = new Node(value);
                n.right.parent = n;
                size++;
                return true;
            } else {
                return add(n.right, value);
            }
        }
    }
    /**
     * remove everything.
     */

    public void clear() {
        root = null;
        size = 0;
    }
    /**
     * @param o object
     * @return true or false
     */

    public boolean contains(Object o) {
        return contains(root, o);
    }
    /**
     * 
     * @param n n
     * @param o o
     * @return true if contains the value
     */

    @SuppressWarnings("unchecked")
    private boolean contains(Node n, Object o) {
        if (n == null) {
            return false;
        }
        if (n.value.equals(o)) {
            return true;
        } else if (n.value.compareTo(o) > 0) {
            return contains(n.left, o);
        } else {
            return contains(n.right, o);
        }
    }
    /**
     * @param o o 
     * @return T t
     */

    public T get(Object o) {
        return get(root, o);
    }
    /**
     * 
     * @param n n
     * @param o o
     * @return t
     */

    @SuppressWarnings("unchecked")
    private T get(Node n, Object o) {
        if (n == null) {
            return null;
        }
        if (n.value.equals(o)) {
            return n.value;
        } else if (n.value.compareTo(o) > 0) {
            return get(n.left, o);
        } else {
            return get(n.right, o);
        }
    }
    /**
     * @param o o
     * @return true or false
     */

    public boolean remove(Object o) {
        Node n = getNode(root, o);
        if (n == null) {
            return false;
        } else {
            removeNode(n);
            return true;
        }
    }
    /**
     * 
     * @param n n
     * @param o o
     * @return node
     */

    @SuppressWarnings("unchecked")
    private Node getNode(Node n, Object o) {
        if (n == null) {
            return null;
        }
        if (n.value.equals(o)) {
            return n;
        } else if (n.value.compareTo(o) > 0) {
            return getNode(n.left, o);
        } else {
            return getNode(n.right, o);
        }
    }
    /**
     * @return true or false
     */

    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Returns the number of elements in this tree.
     *
     * @return int
     */
    public int size() {
        return size;
    }

    /**
     * Returns a string representation of this tree.
     *
     * @return String
     */
    public String toString() {
        String ret = toString(root, "", "");
        if (!ret.equals("")) {
            ret = ret.substring(0, ret.length() - 1);
        }
        return ret;
    }

    /**
     * Returns a string representation of the subtree under a given node.
     * 
     * @param n      Node
     * @param indent String
     * @param branch String
     * @return String
     */
    private String toString(Node n, String indent, String branch) {
        String s = "";
        if (n != null) {
            String prefix = indent + branch;
            if (n.left != null) {
                s += toString(n.left, indent + "      ", "L ");
            }
            s += prefix + n.value.toString() + "\n";
            if (n.right != null) {
                s += toString(n.right, indent + "      ", "R ");
            }
        }
        return s;
    }
    /**
     *  
     * @param n n
     * @param subtree subtree
     */

    private void addToFarRight(Node n, Node subtree) {
        while (n.right != null) {
            n = n.right;
        }
        n.right = subtree;

        if (subtree != null) {
            subtree.parent = n;
        }
    }
    /**
     * 
     * @param n n
     * @param subtree subtree
     */

    private void addToFarLeft(Node n, Node subtree) {
        while (n.left != null) {
            n = n.left;
        }
        n.left = subtree;

        if (subtree != null) {
            subtree.parent = n;
        }
    }
    /**
     * 
     * @param parent parent
     * @param n n
     */

    private void removeRight(Node parent, Node n) {
        if (n.right == null) {
            parent.right = n.left;
            if (n.left != null) {
                n.left.parent = parent;
            }
        } else {
            parent.right = n.right;
            n.right.parent = parent;
            addToFarLeft(parent.right, n.left);
        }
    }
    /**
     * 
     * @param parent parent
     * @param n n
     */

    private void removeLeft(Node parent, Node n) {
        if (n.left == null) {
            parent.left = n.right;
            if (n.right != null) {
                n.right.parent = parent;
            }
        } else {
            n.left.parent = parent;
            parent.left = n.left;
            addToFarRight(parent.left, n.right);
        }
    }

    /**
     * Remove the root node.
     */
    private void removeRoot() {
        if (root.left != null) {
            addToFarRight(root.left, root.right);
            root = root.left;
            root.parent = null;
        } else if (root.right != null) {
            addToFarLeft(root.right, root.left);
            root = root.right;
            root.parent = null;
        } else {
            root = null;
        }
    }
    /**
     * 
     * @param n n
     */
    
    void removeNode(Node n) {
        if (root == n) { // n is the root
            removeRoot();
        } else if (n.parent.left == n) {
            removeLeft(n.parent, n);
        } else {
            removeRight(n.parent, n);
        }
        size--;
    }

    
    /**
     * Main method.
     * 
     * @param args Command line arguments.
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BST<String> t = new BST<String>();
        ArrayList<String> list = new ArrayList<String>();

        String input = sc.nextLine();
        while (!input.equals("x")) {
            String[] tokens = input.split(" ");
            if (tokens[0].equals("a")) { // add(T value)
                String value = tokens[1];
                list.add(value);

                t.add(value);
                System.out.println(t);
            } else if (tokens[0].equals("c")) { // contains(Object o)
                String value = tokens[1];

                System.out.println(t.contains(value));
            } else if (tokens[0].equals("C")) { // clear()
                t.clear();
                list.clear();

                System.out.println(t);
            } else if (tokens[0].equals("r")) { // remove(Object o)
                String value = tokens[1];
                list.remove(value);

                t.remove(value);
                System.out.println(t);
            } else if (tokens[0].equals("g")) { // get(Object o)
                String value = tokens[1];

                System.out.println(t.get(value));
            } else if (tokens[0].equals("e")) { // isEmpty()
                System.out.println(t.isEmpty());
            } else if (tokens[0].equals("s")) { // size()
                System.out.println(t.size());
            }

            // System.out.println("Validation result: " + TreeApp.validateTree( list, t ));
            System.out.println("------------------");
            input = sc.nextLine();
        }
    }
}
