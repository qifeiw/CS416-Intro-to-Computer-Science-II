/**
 * @author Qifei Wang
 * @version 1 CS416 Spring 2024
 */
public class CrawlBot implements Robot {
    private int x;
    private int y;
    private int direction;

    /**
     * default constructor.
     */

    public CrawlBot() {
        this.x = 0;
        this.y = 0;
        this.direction = 0;
    }

    /**
     * 
     * @param x x
     * @param y y
     * @param d direction
     */

    public CrawlBot(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.direction = d;
    }

    // getters for x, y and direction
    /**
     * 
     * @return x
     */

    public int getX() {
        return x;
    }

    /**
     * 
     * @return y
     */

    public int getY() {
        return y;
    }

    /**
     * 
     * @return direction
     */

    public int getDirection() {
        return direction;
    }

    /**
     * turn right.
     */

    public void turnRight() {
        this.direction = (this.direction - 90 + 360) % 360;
    }

    /**
     * turn left.
     */

    public void turnLeft() {
        this.direction = (this.direction + 90) % 360;
    }

    /**
     * 
     * @param dist distance
     */

    public void moveForward(int dist) {
        switch (this.direction) {
            case 0:
                this.x += dist;
                break;
            case 90:
                this.y += dist;
                break;
            case 180:
                this.x -= dist;
                break;
            case 270:
                this.y -= dist;
                break;
        }
    }

    /**
     * 
     * @param dist distance
     */

    public void moveBackward(int dist) {
        switch (this.direction) {
            case 0:
                this.x -= dist;
                break;
            case 90:
                this.y -= dist;
                break;
            case 180:
                this.x += dist;
                break;
            case 270:
                this.y += dist;
        }
    }

    /**
     * @return format of string
     */

    public String toString() {
        return "CrawlBot at (" + this.x + ", " + this.y + ") heading " + this.direction + " degrees";
    }

    /**
     * 
     * @param args arg
     */

    public static void main(String[] args) {
        CrawlBot c = new CrawlBot(3, 2, 90);
        c.turnRight();
        c.moveForward(6);
        System.out.println(c);
    }
}