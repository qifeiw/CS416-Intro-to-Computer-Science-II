/**
 * @author Qifei Wang
 * @version 1
 */

public class Course {

    private String subject;
    private int number;
  
    /**
     * 
     * @param subject course name
     * @param courseNum course number
     */

    public Course(String subject, int courseNum) {
        if (subject.length() > 4) {
            this.subject = subject.substring(0, 4).toUpperCase();
        } else {
            this.subject = subject.toUpperCase();
        }
        if (courseNum >= 400 && courseNum <= 799) {
            this.number = courseNum;
        } else {
            this.number = 401;
        }
    }
    /**
     * @return string formalization
     */

    public String toString(){
        return subject + " " + number;
    }
  
}
  