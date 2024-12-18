/**
 * @author Qifei Wang
 * @version 1.0
 */
public class Rock {
    private String name;
    private double weight;
    private double volume;
    /**
     * 
     * @param rockName Take the name of rock
     */

    public Rock(String rockName) {
        this.name = rockName;
    }
    /**
     * 
     * @return getters
     */

    public String getName() {
        return name;
    }
    /**
     * 
     * @param name input of rock name
     */

    public void setName(String name) {
        this.name = name;
    }
    /**
     * 
     * @param pounds Takes input of weights
     */

    public void setNumPounds(double pounds) {
        this.weight = pounds;
    }
    /**
     * 
     * @return weight
     */

    public double getNumPounds() {
        return weight;
    }
    /**
     * 
     * @param rockVolume Takes rockVolume
     */

    public void setVolume(double rockVolume) {
        this.volume = rockVolume;
    }
    /**
     * 
     * @return volume
     */

    public double getVolume() {
        return volume;
    }
    /**
     * 
     * @return density
     */

    public int calculateDensity() {
        if (volume != 0) {
            return (int) (weight / volume);
        } else {
            return 0;
        }
    }
    /**
     * 
     * @param increaseAmount takes the amount that will be increased
     */

    public void increasePounds(double increaseAmount) {
        weight += increaseAmount;
    }
    /**
     * 
     * @param decreaseAmount takes the amount that will be decreased
     * @return decreased amount
     */

    public double decreasePounds(double decreaseAmount) {
        weight -= decreaseAmount;
        return weight;
    }
    /**
     * @return a formatted string
     */

    public String toString() {
        return String.format("Rock %s weighs %.3f pounds with a density of %d", name, weight, calculateDensity());
    }
    /**
     * 
     * @param args takese 
     */

    public static void main(String[] args) {
        Rock r = new Rock("pet");
        r.setVolume(2.0);
        r.setNumPounds(10.0);
        System.out.println(r.calculateDensity()); 

        r.increasePounds(5.0);
        System.out.println(r.getNumPounds()); 

        System.out.println(r.decreasePounds(5.0)); 

        System.out.println(r); 
    }
}