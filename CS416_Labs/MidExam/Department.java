import java.util.ArrayList;

public class Department {
    private String departName;
    private ArrayList<Course> courseList;

    public Department(String name) {
        this.departName = name;
        courseList = new ArrayList<Course>();
    }

    public void add(Course course) {
        courseList.add(course);
    }

    public void remove(Course course) {
        courseList.remove(course);
    }

    public ArrayList<Course> getListing() {
        return courseList;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(departName).append("\n");
        for (Course course : courseList) {
            result.append(course.toString()).append("\n");
        }
        return result.toString();
    }
}
