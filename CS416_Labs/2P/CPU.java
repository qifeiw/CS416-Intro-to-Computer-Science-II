
/**
 * A class to model a CPU in a simple Virtual Machine.
 * 
 * @author Qifei Wang
 * @version 1
 */

public class CPU {
    private int instructionPointer;
    private int instructionStore;
    private int register0;
    private int register1;
    private boolean isRunning = true;

    /**
     * constructor.
     */

    public CPU() {
        instructionPointer = 0;
        instructionStore = 0;
        register0 = 0;
        register1 = 0;

    }

    /**
     * 
     * @param mem memory
     */

    private void fetch(Memory mem) {
        instructionStore = mem.read(instructionPointer);
    }

    /**
     * 
     * @param mem MEM
     */

    private void execute(Memory mem) {
        int temp;
        switch (instructionStore) {
            case 0:
                isRunning = false;
                break;
            case 1:
                temp = register0 + register1;
                register0 = temp & 0xF;
                instructionPointer += 1;
                break;
            case 2:
                temp = register0 - register1;
                register0 = temp & 0xF;
                instructionPointer += 1;
                break;
            case 3:
                temp = register0 + 1;
                register0 = temp & 0xF;
                instructionPointer += 1;
                break;
            case 4:
                temp = register1 + 1;
                register1 = temp & 0xF;
                instructionPointer += 1;
                break;
            case 5:
                temp = register0 - 1;
                register0 = temp & 0xF;
                instructionPointer += 1;
                break;
            case 6:
                temp = register1 - 1;
                register1 = temp & 0xF;
                instructionPointer += 1;
                break;
            case 7:
                Beep.beep();
                instructionPointer += 1;
                break;
            case 8:
                System.out.println(mem.read(instructionPointer + 1));
                instructionPointer += 2;
                break;
            case 9:
                temp = mem.read(mem.read(instructionPointer + 1));
                register0 = temp;
                instructionPointer += 2;
                break;
            case 10:
                temp = mem.read(mem.read(instructionPointer + 1));
                register1 = temp;
                instructionPointer += 2;
                break;
            case 11:
                mem.write(mem.read(instructionPointer + 1), register0);
                instructionPointer += 2;
                break;
            case 12:
                mem.write(mem.read(instructionPointer + 1), register1);
                instructionPointer += 2;
                break;
            case 13:
                instructionPointer = mem.read(instructionPointer + 1);
                break;
            case 14:
                if (register0 == 0) {
                    instructionPointer = mem.read(instructionPointer + 1);
                } else {
                    instructionPointer += 2;
                }
                break;
            case 15:
                if (register0 != 0) {
                    instructionPointer = mem.read(instructionPointer + 1);
                } else {
                    instructionPointer += 2;
                }
                break;
            default:
                throw new IllegalStateException("Illegal Instruction");
        }
        instructionPointer = instructionPointer & 0xF;
    }

    /**
     * 
     * @param mem       memory
     * @param debugMode debug
     * @throws IllegalStateException illegal
     */

    public void run(Memory mem, boolean debugMode) throws IllegalStateException {
        int step = 0;
        while (isRunning) {
            fetch(mem);
            if (debugMode) {
                System.out.printf("STEP %d:%n", step);
                System.out.println(this);
                System.out.println(mem);
                System.out.println("----------");
            }
            execute(mem);
            step++;

        }
    }

    /**
     * @return string format
     */

    public String toString() {
        return String.format("IP=%2d, IS=%2d, R0=%2d, R1=%2d", instructionPointer, instructionStore, register0,
                register1);
    }
}
