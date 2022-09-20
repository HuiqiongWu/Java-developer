
import java.text.DecimalFormat;
import java.util.Locale;

public abstract class Account {
    private String id;
    private String name;
    private double balance;
    
    public Account(String id, String name, double balance){
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public Account(Account source){
        this.id = source.id;
        this.name = source.name;
        this.balance = source.balance;
    }

    public String getName() {
        return this.name;
    }

    public String getId() {
        return this.id;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public void setName(String name){
        this.name = name;
    }

    public abstract void debit(double amount);
    public abstract boolean credit(double amount);
    public abstract Account clone();

    protected double round(double amount) {
        DecimalFormat formatter = new DecimalFormat("#.##");
        return Double.parseDouble(formatter.format(amount));
    }

}
