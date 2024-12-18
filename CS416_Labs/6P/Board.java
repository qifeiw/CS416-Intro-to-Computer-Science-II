import java.util.Scanner;

/**
 * @author Qifei Wang
 * @version 1
 */

public class Board {
    private int[][] board;

    /**
     * @param sc sc
     */

    public Board(Scanner sc) {
        this.board = new int[9][9];
        board = readBoard(sc);
    }

    /**
     * 
     * @param sc sc
     * @return result
     */

    public static int[][] readBoard(Scanner sc) {
        int[][] rel = new int[9][9];
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                rel[r][c] = 0;
            }
        }
        String rowLine;
        for (int r = 0; r < 9; r++) {
            rowLine = sc.nextLine();
            for (int c = 0; c < 9; c++) {
                if (c >= rowLine.length()) {
                    System.err.println("Row" + r + "Not enough inputs.");
                    return null;
                } else {
                    char ch = rowLine.charAt(c);
                    if (ch == '-') {
                        ch = '0';
                    }
                    int value = ch - '0';
                    if (value >= 0 && value <= 9) {
                        rel[r][c] = value;
                    } else {
                        System.err.println("Invalid value " + ch + " at position " + r + " , " + c);
                        return null;
                    }
                }
            }
        }
        return rel;
    }

    /**
     * 
     * @param row row
     * @param col col
     * @return value
     */

    public int get(int row, int col) {
        return this.board[row][col];
    }

    /**
     * 
     * @param row   row
     * @param col   col
     * @param value value
     */

    public void set(int row, int col, int value) {
        this.board[row][col] = value;
    }

    /**
     * 
     * @param row    row
     * @param number number
     * @return true or false
     */

    public boolean containsInRow(int row, int number) {
        for (int c = 0; c < 9; c++) {
            if (this.board[row][c] == number) {
                return true;
            }
        }
        return false;
    }

    /**
     * 
     * @param col    col
     * @param number number
     * @return true or false
     */

    public boolean containsInCol(int col, int number) {
        for (int r = 0; r < 9; r++) {
            if (this.board[r][col] == number) {
                return true;
            }
        }
        return false;
    }

    /**
     * 
     * @param row    row
     * @param col    col
     * @param number number
     * @return true or false
     */

    public boolean isAllowed(int row, int col, int number) {

        if (get(row, col) == 0 && !(containsInRow(row, number))
                && !(containsInCol(col, number))
                && !(containsInBox(row, col, number))) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 
     * @param row    row
     * @param col    col
     * @param number number
     * @return true or false
     */

    public boolean containsInBox(int row, int col, int number) {
        int r = row - row % 3;
        int c = col - col % 3;
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (this.board[i][j] == number) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @return String
     */

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < 9; r++) {
            if (r % 3 == 0) {
                sb.append("+-------+-------+-------+\n");
            }
            for (int c = 0; c < 9; c++) {
                if (c % 3 == 0) {
                    sb.append("| ");
                }
                int val = get(r, c);
                if (val < 0) {
                    val = -val;
                }
                if (val > 0) {
                    sb.append(get(r, c)).append(" ");
                } else {
                    sb.append("- ");
                }
            }
            sb.append("|\n");
        }
        sb.append("+-------+-------+-------+");
        return sb.toString();
    }
}
