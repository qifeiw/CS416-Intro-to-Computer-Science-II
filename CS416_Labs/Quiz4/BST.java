/**
 * @author Qifei Wang
 * @version 1
 */

public class BST {

    Node root;

    /**
     * constructor.
     */

    public BST() {

    }

    /**
     * 
     * @param data data
     */

    public void add(String data) {
        Node n = new Node(data);
        if (root == null) {
            root = n;
            return;
        }

        Node curr = root;
        boolean added = false;
        while (!added) {
            int c = curr.data.compareTo(data);
            if (c > 0) {
                if (curr.left == null) {
                    curr.left = n;
                    added = true;
                    n.parent = curr;
                } else {
                    curr = curr.left;
                }
            } else {
                if (curr.right == null) {
                    curr.right = n;
                    added = true;
                    n.parent = curr;
                } else {
                    curr = curr.right;
                }
            }
        }
    }

    /**
     * 
     */

    public class Node {
        String data;
        Node left;
        Node right;
        Node parent;

        /**
         * 
         * @param data data
         */

        public Node(String data) {
            this.data = data;
        }
    }

    // YOUR CODE HERE
    /**
     * 
     * @return string
     */

    public String min() {
        if (root == null) {
            return null;
        }

        Node curr = root;
        while (curr.left != null) {
            curr = curr.left;
        }
        return curr.data;
    }
}
