/**
 * @author Qifei Wang
 * @version 1
 */

public class Point {
    private double x;
    private double y;
    /**
     * 
     * @param x x
     * @param y y
     */

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
  
    // YOUR CODE HERE
    /**
     * 
     * @param p p
     * @return pointer
     */
    public Point max(Point p) {
        double maxX = Math.max(this.x, p.x);
        double maxY = Math.max(this.y, p.y);
        return new Point(maxX, maxY);
    }
    /**
     * @return String formalization
     */

    public String toString() {
        return String.format("(%.2f, %.2f)", x, y);
    }
   
}
