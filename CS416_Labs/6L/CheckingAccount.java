/**
 * @author Qifei Wang
 * @version 1
 */
public class CheckingAccount implements Account {
    private int balance;
    private String id;
    private String name;
    /**
     * 
     * @param id account id
     * @param name account name
     * @param startingBalance account's starting balance
     */

    public CheckingAccount(String id, String name, int startingBalance) {
        this.balance = startingBalance;
        this.id = id;
        this.name = name;
    }
    /**
     * 
     * @param amount deposits of amount
     */

    public void deposit(int amount) {
        this.balance += amount;
    }
    /**
     * 
     * @param amount withfraw amount
     * @return boolean 
     */

    public boolean withdraw(int amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
            return true;
        } else {
            return false;
        }
    }
    /**
     * 
     * @return balance
     */

    public int getBalance() {
        return balance;
    }
    /**
     * 
     * @return account id
     */

    public String getId() {
        return id;
    }
    /**
     * 
     * @return account name
     */

    public String getName() {
        return name;
    }
    /**
     * @return String
     */

    public String toString() {
        return String.format("%s %s $%d", id, name, balance);
    }
    /**
     * 
     * @param args account
     */

    /*public static void main(String[] args) {
        CheckingAccount s = new CheckingAccount("a1001", "Ayesha Reynolds", 1520);
        System.out.println(s);
    } */
}
