import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Qifei Wang
 * @version 1
 * @param <V> v
 * @param <K> K
 */

public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

    private BST<Entry<K, V>> t;

    /**
     * Default constructor.
     */
    public BSTMap() {
        t = new BST<Entry<K, V>>();
    }

    /**
     * Class to represent an entry in a map.
     * 
     * @author QW
     * @version 1
     * @param <K> Key
     * @param <V> Value
     */
    public class Entry<K extends Comparable, V> implements Map.Entry, Comparable {
        private K key;
        private V value;

        /**
         * Constructor.
         * 
         * @param key   K Key
         * @param value V Value
         */

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        /**
         * Get the key associated with an entry.
         * 
         * @return K key
         */

        public K getKey() {
            return key;
        }

        /**
         * Get the value associated with an entry.
         * 
         * @return V value
         */

        public V getValue() {

            return value;
        }

        /**
         * Print a nice human readable map entry of form (key, value).
         * 
         * @return String
         */
        public String toString() {
            return "(" + key + ", " + value + ")";
        }

        /**
         * Check if two Entries are equal.
         * We will say that two entries are equal if either their keys or values match.
         * 
         * @param o Object
         * @return boolean
         */
        @Override
        public boolean equals(Object o) {
            // If the object is compared with itself then return true
            if (o == this) {
                return true;
            }

            /*
             * Check if o is an instance of Entry or not
             * "null instanceof [type]" also returns false
             */
            if (o instanceof BSTMap.Entry) {
                // typecast o to Entry so that we can compare data members
                Entry e = (Entry) o;
                return e.getKey().equals(key) && e.getValue().equals(value);
            } else {
                return key.equals(o);
            }
        }

        /**
         * Compare two entries.
         * 
         * @param o Object
         * @return Integer
         */

        @SuppressWarnings("unchecked")
        public int compareTo(Object o) {
            // If the object is compared with itself then return true
            if (o == this) {
                return 0;
            }

            /*
             * Check if o is an instance of Entry or not
             * "null instanceof [type]" also returns false
             */
            if (o instanceof Entry) {
                // typecast o to Entry so that we can compare data members
                Entry<K, V> e = (Entry<K, V>) o;
                return key.compareTo(e.key);
            } else {
                return key.compareTo(o);
            }
        }
    }

    /**
     * Return the tree.
     * 
     * @return Tree
     */

    public BST<Entry<K, V>> getTree() {
        return t;
    }

    /**
     * clear.
     */

    public void clear() {
        t.clear();
    }

    /**
     * @param key key
     * @return true or false
     */

    public boolean containsKey(K key) {
        return t.contains(key);
    }

    /**
     * @param key key
     * @return V v
     */

    public V get(K key) {
        Entry<K, V> entry = t.get(key);
        if (entry != null) {
            return entry.getValue();
        }
        return null;
    }

    /**
     * @param key   key
     * @param value value
     * @return V v
     */

    public V put(K key, V value) {
        V v = get(key);
        if (!containsKey(key)) {
            Entry<K, V> e = new Entry<K, V>(key, value);
            t.add(e);
        } else {
            Entry<K, V> e = t.get(key);
            e.value = value;
        }
        return v;
    }

    /**
     * @param key   key
     * @param value value
     * @return V
     */

    public V putIfAbsent(K key, V value) {
        V v = get(key);
        if (!containsKey(key)) {
            Entry<K, V> e = new Entry<K, V>(key, value);
            t.add(e);
        }
        return v;
    }

    /**
     * Returns true if this map contains no key-value mappings.
     *
     * @return true if this map contains no key-value mappings
     */
    public boolean isEmpty() {
        return t.isEmpty();
    }

    /**
     * @param key key
     * @return V v
     */

    public V remove(K key) {
        V ret = t.get(key).getValue();
        t.remove(key);
        return ret;
    }

    /**
     * @return size
     */

    public int size() {
        return t.size();
    }

    /**
     * @return string
     */

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(t.toString());
        return s.toString();
    }

    /**
     * Main method.
     * 
     * @param args Command line arguments.
     */

    /*
     * public static void main(String[] args) {
     * Scanner sc = new Scanner(System.in);
     * 
     * BSTMap<String, Integer> b = new BSTMap<String, Integer>();
     * ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>();
     * 
     * String input = sc.nextLine();
     * while (!input.equals("x")) {
     * String[] tokens = input.split(" ");
     * if (tokens[0].equals("p")) {
     * String key = tokens[1];
     * Integer value = Integer.parseInt(tokens[2]);
     * list.add(b.new Entry<String, Integer>(key, value));
     * 
     * b.put(key, value);
     * System.out.println(b);
     * } else if (tokens[0].equals("P")) {
     * String key = tokens[1];
     * Integer value = Integer.parseInt(tokens[2]);
     * b.putIfAbsent(key, value);
     * System.out.println(b);
     * } else if (tokens[0].equals("c")) {
     * String key = tokens[1];
     * 
     * System.out.println(b.containsKey(key));
     * } else if (tokens[0].equals("C")) {
     * b.clear();
     * list.clear();
     * 
     * System.out.println(b);
     * } else if (tokens[0].equals("r")) {
     * list.remove(key);
     * 
     * b.remove(key);
     * System.out.println(b);
     * } else if (tokens[0].equals("e")) {
     * System.out.println(b.isEmpty());
     * } else if (tokens[0].equals("s")) {
     * System.out.println(b.size());
     * } else if (tokens[0].equals("g")) {
     * 
     * System.out.println(b.get(key));
     * }
     * 
     * System.out.println("------------------");
     * input = sc.nextLine();
     * }
     * }
     */
}
