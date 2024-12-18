/**
 * @author Qifei Wang
 * @version 1 Recitation2, Book. Spring 2024
 */
public class Book {
    private String title;
    private double price;
    private Author[] authors;
    /**
     * 
     * @param title title
     * @param authors authors
     * @param price price
     */

    public Book(String title, Author[] authors, double price) {
        this.title = title;
        this.authors = authors;
        this.price = price;
    }
    /**
     * 
     * @return title
     */

    public String getTitle() {
        return title;
    }
    /**
     * 
     * @param title title
     */

    public void setTitle(String title) {
        this.title = title;
    }
    /**
     * 
     * @param price pric
     */

    public void setPrice(double price) {
        this.price = price;
    }
    /**
     * 
     * @return price
     */

    public double getPrice() {
        return price;
    }
    /**
     * 
     * @return authors
     */

    public Author[] getAuthors() {
        return this.authors;
    }
    /**
     * 
     * @return author names
     */

    public String getAuthorNames() {
        StringBuilder names = new StringBuilder();
        for (int i = 0; i < authors.length; i++) {
            names.append(authors[i].getName());
            if (i < authors.length - 1) {
                names.append(", ");
            }
        }
        return names.toString();
    }
    /**
     * @return string format
     */

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Book[title=").append(this.title).append(", authors={");
        for (int i = 0; i < authors.length; i++) {
            sb.append(authors[i].toString());
            if (i < authors.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("}, price=$").append(String.format("%.2f", this.price)).append("]");
        return sb.toString();
    }
    /**
     * @param args args
     */

    public static void main(String[] args) {
        Author[] authors = {
            new Author("John Doe", "jodoe@techwriter.com"),
            new Author("Jan Doe", "jadoe@techwriter.com")};
        Book b = new Book("All About Java", authors, 45.0);
        System.out.println(b);
    }
}
