/**
 * @author Qifei Wang
 * @version 1
 */

public class PhoneBook {
    TreeNode<String, String> root;
    
    public PhoneBook() {
        root = null;
    }

    public void add(String Name, String Number) {
        if (root == null) {
            root = new TreeNode<> (Name, Number)；
        } else {
            addHelper(root, Name, Number);
        }

    }
    private void addHelper(TreeNode<String, String> n, String k, String v ) {
        int cmp = n.getKey().compareTo(k);
        if (cmp == 0) {
            n.setValue(v);
        } else if (cmp < 0) {
            if (n.right != null) {
                addHelper(n.right, k, v);
            } else {
                n.right = new TreeNode<>(k,v);
            }
        } else {
            if (n.left != null) {
                addHelper(n.left, k,v);
            } else {
                n.left = new TreeNode<>(k,v);
            }

        }
    }
    public String get(String k) {
        return getHelper(root,k);
    }
    public String getHelper(TreeNode<String, String> n, String k) {
        if (n == null) {
            return null;
        }
        int cmp = n.getKey().compareTo(k);
        if (cmp == 0) {
            return n.getValue();
        } else if (cmp < 0) {
            return getHelper(n.right, k);
        } else {
            return getHelper(n.left,k);
        }
    }
    public String toString() {
        return null;
    }
    public static void main(String[] args) {
        PhoneBook b = new PhoneBook();
        b.add("A", "123-456-7880");
        b.add("B", "603-111-4569");
        b.add("C","603-256-8888");
        System.out.println(b.get("A"));
    }
}
