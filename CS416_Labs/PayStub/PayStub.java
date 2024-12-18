import java.util.Scanner;

/**
 * @author Qifei Wang
 * @version 1 PayStub Sping 2024
 */
public class PayStub {
    // Data Members

    private String name;
    private int aniversaryMonth;
    private int aniversaryYear;
    private int hoursWorked;
    private String jobTitle;
    private double hourlyPayRate;

    private final double vacationRate = 8.25;
    private final double retirementRate = 0.052;
    private final double taxRate = 0.280;
    private int currentYear = 2019;
    private int currentMonth = 1;

    /**
     * Constructor 1.
     */

    public PayStub() {
        name = null;
        aniversaryMonth = 0;
        aniversaryYear = 0;
        hoursWorked = 0;
        jobTitle = null;
        hourlyPayRate = 0.0d;
    }

    /**
     * 
     * Parameterized constructor with intial value.
     * 
     * @param employeName     name of employees
     * @param aniversaryMonth aniversary month
     * @param aniversaryYear  aniversary year
     * @param hours           hours
     * @param title           job title
     * @param payRate         pay rate
     */

    public PayStub(String employeName, int aniversaryMonth, int aniversaryYear, int hours, String title,
            double payRate) {
        this.name = employeName;
        this.aniversaryMonth = aniversaryMonth;
        this.aniversaryYear = aniversaryYear;
        this.hoursWorked = hours;
        this.jobTitle = title;
        this.hourlyPayRate = payRate;
    }

    /**
     * 
     * @return name
     */
    // getName method

    public String getName() {
        return name;
    }

    /**
     * 
     * @return month
     */

    public int getMonth() {
        return aniversaryMonth;
    }

    /**
     * 
     * @return year
     */

    public int getYear() {
        return aniversaryYear;
    }

    /**
     * 
     * @return hours
     */

    public int getHours() {
        return hoursWorked;
    }

    /**
     * 
     * @return title
     */

    public String getTitle() {
        return jobTitle;
    }

    /**
     * 
     * @return pay rate
     */

    public double getPayRate() {
        return hourlyPayRate;
    }

    /**
     * 
     * method to calculate the months worked.
     * 
     * @param year  year
     * @param month month
     * @return months worked
     * 
     */

    public int numMonthsWorked(int year, int month) {
        int temp;
        temp = (currentYear - year) * 12;
        temp += currentMonth - month;
        return temp;
    }

    /**
     * Method to calculate the vacation hours.
     * 
     * @return vacation hours
     */

    public double vacationHours() {
        return numMonthsWorked(aniversaryYear, aniversaryMonth) * vacationRate;
    }

    /**
     * Method to calculate gross Pay.
     * 
     * @return groos pay
     */

    public double grossPay() {
        return hoursWorked * hourlyPayRate;
    }

    /**
     * Method to calculate the retirement witholding.
     * 
     * @return retirement hold
     */

    public double retHold() {
        return grossPay() * retirementRate;
    }

    /**
     * Method to calculate the tax withholding.
     * 
     * @return tax
     */

    public double tax() {
        return (grossPay() - retHold()) * taxRate;
    }

    /**
     * Method to calculate the netPay.
     * 
     * @return netPay
     */

    public double netPay() {
        return grossPay() - retHold() - tax();
    }

    /**
     * Method to draw logo.
     */

    public void drawLogo() {
        System.out.println("==========================================");
        System.out.println("      Gekko & Co.");
        System.out.println();
        System.out.println("          \"$\"");
        System.out.println("          ~~~");
        System.out.println("         /  \\ `.");
        System.out.println("        /    \\  /");
        System.out.println("       /_ _ _ \\/");
        System.out.println();
        System.out.println("------------------------------------------");
    }

    /**
     * Method to print the info.
     */

    public void printInfo() {
        System.out.println("Pay Period:     "
                + currentMonth
                + "/" + currentYear);
        System.out.println("Name:           " + name);
        System.out.println("Title:          " + jobTitle);
        System.out.println("Anniversary:    " + aniversaryMonth + "/" + aniversaryYear);
        System.out.println("Months Worked:  "
                + numMonthsWorked(aniversaryYear, aniversaryMonth) + " months");

        System.out.printf("Vacation hours: %.2f\n", vacationHours());

        System.out.println("------------------------------------------");

        System.out.printf("Gross Pay:     $%7.2f\n", grossPay());
        System.out.printf("Retirement:    $%7.2f\n", retHold());
        System.out.printf("Tax:           $%7.2f\n", tax());
        System.out.println("------------------------");
        System.out.printf("Net Pay:       $%7.2f\n", netPay());
        System.out.println("==========================================");
    }

    /**
     * Main method to take input of users.
     * 
     * @param args take input from user
     */

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        // get user's full name
        System.out.print("Enter your Fullname: ");
        String fullName = scn.nextLine();
        // get aniversary month
        System.out.print("Enter your Anniversary Month(1-12): ");
        int month = scn.nextInt();
        scn.nextLine();

        // get Aniversary Year
        System.out.print("Enter your Anniversary Year: ");
        int year = scn.nextInt();
        scn.nextLine();

        // get hours worked this pay period
        System.out.print("Enter your hours worked this pay period(0-350): ");
        int hours = scn.nextInt();
        scn.nextLine();

        // get job title
        System.out.print("Enter your Job Title: ");
        String title = scn.nextLine();

        // get pay rate
        System.out.print("Enter your pay rate: ");
        double payRate = scn.nextDouble();

        scn.close();

        // creat object of the class
        PayStub ps = new PayStub(fullName, month, year, hours, title, payRate);
        ps.drawLogo();
        ps.printInfo();

    }
}