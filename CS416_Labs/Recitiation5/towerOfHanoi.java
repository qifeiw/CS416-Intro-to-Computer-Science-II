/**
 * @author Qifei Wang
 * @version 1
 */

public class towerOfHanoi {
    /**
     * 
     * @param disks disks
     * @param from from
     * @param to to
     * @param spare spare
     */

    public static void towersOfHanoi(int disks, int from, int to, int spare) {
        //Base case
        if (disks == 1) {
            System.out.println("Move disk 1 from rod " + from + " to rod " + to);
            return;
        }
        //Recursive case
        towersOfHanoi(disks - 1, from, spare, to);
        System.out.println("Move disk " + disks + " from rod " + from + " to rod " + to);
        towersOfHanoi(disks - 1, spare, to, from);

    }
    /**
     * 
     * @param args args
     */

    public static void main(String[] args) {
        int numberOfDisks = 10; // Number of disks
        towersOfHanoi(numberOfDisks, 0, 1, 2);
    }

}