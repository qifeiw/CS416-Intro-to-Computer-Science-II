import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author Qifei Wang
 * @version 1
 */

public class Sudoku {
    private Board board;
    private int backupCount;
    private int recursionCount;

    /**
     * 
     * @param sc scanner
     */

    public Sudoku(Scanner sc) {
        this.board = new Board(sc);
    }

    /**
     * 
     * @param loc loc
     * @return true or false
     */

    public boolean solve(Location loc) {
        recursionCount++;
        boolean solved = false;
        if (loc == null) {
            return true;
        }
        int row = loc.getRow();
        int col = loc.getColumn();
        int value = board.get(row, col);
        if (value != 0) {
            solved = solve(loc.next());
        } else {
            for (int val = 1; val < 10 && !solved; val++) {
                board.set(row, col, 0);
                if (board.isAllowed(row, col, val)) {
                    board.set(row, col, val);
                    solved = solve(loc.next());
                }
            }
            if (!solved) {
                board.set(row, col, 0);
                backupCount++;
            }
        }
        return solved;
    }

    /**
     * 
     * @return resursionCount
     */

    public int getRecursionCount() {
        return recursionCount;
    }

    /**
     * 
     * @return backupCount
     */

    public int getBackupCount() {
        return backupCount;
    }

    /**
     * 
     * @return board
     */

    public Board getBoard() {
        return board;
    }

    /**
     * 
     * @param args args
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the path to Sudoku file:");
        String fileName = sc.nextLine();
        try {
            sc = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("Can't find the file : " + fileName);
            e.printStackTrace();
            System.exit(-1);
        }
        Sudoku s = new Sudoku(sc);
        System.out.println("Initial configuration of the sudoku");
        System.out.println(s.getBoard());
        if (s.solve(new Location(0, 0))) {
            System.out.println("Successful!");
            System.out.println("Final configuration of the sudoku");
            System.out.println(s.getBoard());
            System.out.println("Recursion count = " + s.getRecursionCount());
            System.out.println("Backup count = " + s.getBackupCount());
        } else {
            System.out.println("Unsuccessful!");
            System.out.println("Recursion count = " + s.getRecursionCount());
            System.out.println("Backup count = " + s.getBackupCount());
        }

    }
}
