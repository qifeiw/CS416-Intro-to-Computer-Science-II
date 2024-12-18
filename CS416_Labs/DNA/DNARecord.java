/**
 * @author Qifei Wang
 * @version 1
 */

public class DNARecord {
    private String name;
    private Profile profile;

    // constructor
    /**
     * 
     * @param name    name
     * @param profile profile
     */

    public DNARecord(String name, Profile profile) {
        this.name = name;
        this.profile = profile;
    }

    // getters for name
    /**
     * 
     * @return name
     */

    public String getName() {
        return name;
    }

    // getters for profile
    /**
     * 
     * @return profile
     */

    public Profile getProfile() {
        return profile;
    }

    @Override
    public String toString() {
        return name + ": " + profile.toString();
    }
}
