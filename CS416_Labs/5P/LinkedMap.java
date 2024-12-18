
public class LinkedMap<K, V> implements Map<K, V> {
    private LinkedList<Entry<K, V>> list;

    // constructor
    public LinkedMap() {
        this.list = new LinkedList<>();
    }

    public LinkedList<Entry<K, V>> getList() {
        return list;
    }

    public V put(K key, V value) {
        V v = get(key);
        if (!containsKey(key)) {
            Entry<K, V> e = new Entry<K, V>(key, value);
            list.add(e);
        } else {
            Entry<K, V> e = list.get(key);
            e.value = value;
        }
        return v;
    }

    public V putIfAbsent(K key, V value) {
        V v = get(key);
        if (!containsKey(key)) {
            Entry<K, V> e = new Entry<K, V>(key, value);
            list.add(e);
        }
        return v;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(list);
        return s.toString();
    }

    public void clear() {
        this.list = new LinkedList<>();
    }

    public V get(K key) {
        Entry<K, V> e = list.get(key);
        if (e != null) {
            return e.getValue();
        }
        return null;
    }

    public boolean containsKey(K key) {
        Entry<K, V> e = list.get(key);
        return e != null;
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public V remove(K key) {
        if (!this.containsKey(key)) {
            return null;
        }
        Entry<K, V> e = list.get(key);
        if (e != null) {
            V value = e.getValue();
            list.remove(e);
            return value;
        }
        return null;
    }

    public int size() {
        return list.size();
    }

    // inner class
    public class Entry<K, V> implements Map.Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public String toString() {
            return "(" + key + ", " + value + ")";
        }

        public void setValue(V value) {
            this.value = value;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (o instanceof Entry) {
                Entry e = (Entry) o;
                return e.getKey().equals(key) && e.getValue().equals(value);
            } else {
                return key.equals(o);
            }
        }
    }

}
