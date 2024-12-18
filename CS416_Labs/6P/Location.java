/**
 * @author Qifei Wang
 * @version 1
 */

public class Location {
    private int row;
    private int col;

    /**
     * 
     * @param row row 
     * @param col col
     */

    public Location(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /**
     * 
     * @return row
     */

    public int getRow() {
        return row;
    }

    /**
     * 
     * @return col
     */

    public int getColumn() {
        return col;
    }

    /**
     * 
     * @return next location
     */

    public Location next() {
        int col = this.col;
        int row = this.row;
        if (col < 8) {
            col++;
        } else if (row < 8) {
            col = 0;
            row++;
        } else {
            return null;
        }
        return new Location(row, col);
    }

    /**
     * @return String
     */

    public String toString() {
        return this.row + ", " + this.col;
    }
}