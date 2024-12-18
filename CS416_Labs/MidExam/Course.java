public class Course {
    private String name;
    private int sectionNum;

    public Course(String name, int section) {
        this.name = name;
        this.sectionNum = section;
    }

    @Override
    public String toString() {
        return name + " " + sectionNum;
    }

    public String getName() {
        return name;
    }

    public int getSection() {
        return sectionNum;
    }
}