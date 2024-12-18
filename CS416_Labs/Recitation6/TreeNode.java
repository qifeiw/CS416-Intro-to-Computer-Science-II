/**
 * @author Qifei Wang
 * @version 1
 * @param <K> k
 * @param <V> v
 * 
 */

public class TreeNode <K extends Comparable<K>, V> {
    K key;
    V value;
    TreeNode<K, V> right;
    TreeNode<K, V> left;

    //constructor;
    /**
     * 
     * @param key key 
     * @param value value
     */
    public TreeNode(K key, V value) {
        this.key = key;
        this.value = value;
        left = null;
        right = null;
    }
    /**
     * 
     * @return key
     */

    public K getKey() {
        return key;
    }
    /**
     * 
     * @param value value
     */

    public void setValue(V value) {
        this.value = value;
    }
    /**
     * 
     * @return value
     */

    public V getValue() {
        return value;
    }
    /**
     * @return String
     */

    public String toString() {
        return key + " -> " + value;
    }
    /**
     * 
     * @param args args
     */

    public static void main(String[] args) {
        TreeNode<K, V> t1 = new TreeNode("A", 1);
        TreeNode t2 = new TreeNode(1, "Apple");
        assert t1.getKey().equals("A");
        assert t1.getValue().equals(1);
        assert t1.toString().equals("A -> 1");
        t2.setValue("Zebra");
        assert t2.getKey().equals(1);
        assert t2.getValue().equals("Zebra");
        assert t2.toString().equals("1 -> Zebra");
    }

}