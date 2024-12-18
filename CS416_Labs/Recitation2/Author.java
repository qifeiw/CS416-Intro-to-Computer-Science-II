/**
 * @author Qifei Wang
 * @version 1 Recitation 2, Author, Spring 2024
 */
public class Author {
    private String name;
    private String email;

    /**
     * constructor 1.
     */

    public Author() {
        this.name = "";
        this.email = "";
    }

    /**
     * 
     * @param name  name
     * @param email email
     */

    public Author(String name, String email) {
        this.name = name;
        this.email = email;
    }

    /**
     * 
     * @return name
     */

    public String getName() {
        return name;
    }

    /**
     * 
     * @param name name
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @param email email
     */

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 
     * @return email
     */

    public String getEmail() {
        return email;
    }

    /**
     * @return format
     */

    public String toString() {
        return name + " <" + email + ">";
    }

    /**
     * 
     * @param args args
     */

    public static void main(String[] args) {
        Author a = new Author("J. Doe", "jdoe@doewriter.com");
        System.out.println(a);
    }
}