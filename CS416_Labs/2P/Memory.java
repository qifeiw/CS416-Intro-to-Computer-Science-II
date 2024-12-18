
//import java.util.InputMismatchException;
//import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * A class to model a Simple Virtual machine Memory.
 * 
 * @author Qifei Wang
 * @version 1
 *
 */

public class Memory {
    private int[] memory;

    /**
     * no argument constructor.
     */

    public Memory() {
        memory = new int[16];
    }

    /**
     * 
     * @param s input
     */

    /*
     * public Memory(Scanner s) {
     * this(); // initialize the memory
     * for (int i = 0; i < memory.length; i++) {
     * memory[i] = s.nextInt() & 0xF;
     * }
     * }
     */

    public Memory(Scanner s) {
        memory = new int[16];
        int curr = 0;
        while (s.hasNextInt()) {
            int val = s.nextInt();
            write(curr, val);
            curr++;
        }
    }

    /**
     * 
     * @param address address
     * @return int
     * @throws IllegalStateException i
     */

    public int read(int address) throws IllegalStateException {
        if (address < 0 || address >= memory.length) {
            throw new IllegalStateException("Invalid address access");
        }
        return memory[address];
    }

    /**
     * 
     * @param address address
     * @param value   vaulue
     * @throws IllegalStateException illi
     */

    public void write(int address, int value) throws IllegalStateException {
        if (address < 0 || address >= memory.length) {
            throw new IllegalStateException("Address is out of range");
        } else {
            memory[address] = value & 0xF;
        }
    }

    /**
     * @return string format
     */

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("address: ");
        for (int i = 0; i < memory.length; i++) {
            s.append("|   ").append(i).append(" ");
        }
        s.append("|\n  value: ");
        for (int val : memory) {
            s.append("|   ").append(val).append(" ");
        }
        s.append("|");
        return s.toString();
    }

    /**
     * 
     * @return array
     */

    public int[] rawMemory() {
        return memory;
    }

    /**
     * 
     * @param args input
     */

    /*
     * public static void main(String[] args) {
     * //Scanner s = new Scanner(System.in);
     * Memory m = new Memory();
     * //m.write(3, 5);
     * //int r = m.read(3);
     * System.out.print(m);
     * }
     */
}
