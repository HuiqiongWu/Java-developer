import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Transaction implements Comparable<Transaction>{
    public enum type {DEPOSIT, WITHDRAW};

    private String id;
    private type trans_type;
    private double amount;
    private long timestamp;

    public Transaction(String id, double amount, type trans_type, long timestamp){
        this.id = id;
        if (amount > 0) {
            this.trans_type = type.DEPOSIT;
        }
        else{
            this.trans_type = type.WITHDRAW;
        }
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public Transaction(Transaction source){
        this.id = source.id;
        if (source.amount > 0) {
            this.trans_type = type.DEPOSIT;
        }
        else{
            this.trans_type = type.WITHDRAW;
        }
        this.amount = source.amount;
        this.timestamp = source.timestamp;
    }

    public String getId() {
        return this.id;
    }

    public double getAmount() {
        return this.amount;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public type getTransType() {
        return this.trans_type;
    }


    public void setAmount(double amount){
        this.amount = amount;
    }

    public String returnDate(){
        Date date = new Date(this.timestamp * 1000);
        return new SimpleDateFormat("dd-MM-yyyy").format(date);
    }

    @Override
    public boolean equals(Object o){
        if (o == this) {
            return true;
        }
        if (!(o instanceof Transaction)){
            return false;
        }
        Transaction transaction = (Transaction) o;
        return Objects.equals(trans_type, transaction.trans_type) && timestamp == transaction.timestamp && Objects.equals(id, transaction.id) && amount == transaction.amount;       
    }

    @Override
    public int hashCode(){
        return Objects.hash(trans_type, timestamp, id, amount);
    }

    @Override
    public int compareTo(Transaction o){
        return Double.compare(this.timestamp, o.timestamp);
    }


}
