/**
 * @author Qifei Wang
 * @version 1
 */

public class Profile {
    private int agatCount;
    private int aatgCount;
    private int tatcCount;
    /**
     * 
     * @return agatCount
     */

    public int getAgatCount() {
        return agatCount;
    }
    /**
     * 
     * @return aatgCount
     */

    public int getAatgCount() {
        return aatgCount;
    }
    /**
     * 
     * @return tatcCount
     */

    public int getTatcCount() {
        return tatcCount;
    }
    /**
     * 
     * @param agat agatCount
     */

    public void setAgatCount(int agat) {
        agatCount = agat;
    }
    /**
     * 
     * @param aatg aatgCount
     */

    public void setAatgCount(int aatg) {
        aatgCount = aatg;
    }
    /**
     * 
     * @param tatc tatc
     */

    public void setTatcCount(int tatc) {
        tatcCount = tatc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Profile profile = (Profile) o;
        return agatCount == profile.agatCount 
            && aatgCount == profile.aatgCount 
            && tatcCount == profile.tatcCount;
    }

    @Override
    public String toString() {
        return "(AGAT = " + agatCount + ", AATG = " + aatgCount + ", TATC = " + tatcCount + ")";
    }
}
