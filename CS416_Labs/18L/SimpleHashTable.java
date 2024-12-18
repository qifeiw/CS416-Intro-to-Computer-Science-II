/**
 * @author Qifei Wang
 * @version 1
 */
public class SimpleHashTable {
    private String[] data = new String[10];

    /**
     * 
     * @param key   key
     * @param value value
     */

    public void put(int key, String value) {
        int size = 10;
        int r = 2;
        int index = hash(key, size, r);
        data[index] = value;
    }

    /**
     * 
     * @param key key
     * @return value
     */

    public String get(int key) {
        int index = hash(key, 10, 2);
        return data[index];

    }

    /**
     * @return string
     */

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            sb.append(i).append(" ").append(data[i]).append("\n");
        }
        return sb.toString();
    }

    /**
     * 
     * @param key  key
     * @param size size
     * @param r    r
     * @return int
     */

    public static int hash(int key, int size, int r) {
        String result = String.valueOf(key * key);
        int length = result.length();
        int midStart = length / 2;
        if (length % 2 == 0) {
            midStart -= 1;
        }
        int midEnd = midStart + r;
        int midDigit = Integer.parseInt(result.substring(midStart, midEnd));
        return midDigit % size;
    }

    /**
     * 
     * @param args args
     */

    public static void main(String[] args) {
        SimpleHashTable hash = new SimpleHashTable();
        hash.put(12, "Value for 12");
        hash.put(199, "Pear");
        System.out.println("Value for 288: " + hash.get(288));
        System.out.println("Current Hash table: " + hash.toString());

    }

}
