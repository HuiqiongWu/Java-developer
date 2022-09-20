
public class ChequingAccount extends Account implements Taxable {

    private static final double overdraft_fee = 5.5;
    private static final double overdraft_limit = -200.00;
    private static final double taxable_income = -30000;
    private static final double tax_rate = 0.15;

    public ChequingAccount(String id, String name, double balance) {
        super(id, name, balance);
    }

    public ChequingAccount(ChequingAccount source){
        super(source);
    }

    @Override
    public Account clone(){
        return new ChequingAccount(this);
    }

    @Override
    public void debit (double amount) {
        super.setBalance(super.getBalance()+amount);
    }


    @Override
    public boolean credit(double amount) {

        if ((super.getBalance()-amount) > 0) {
            super.setBalance(super.getBalance()-amount); 
            return true;
        }
        else if ((super.getBalance()-amount) >= overdraft_limit) {
            super.setBalance(super.getBalance()-amount-overdraft_fee);
            return true;
        }
        else {
            System.out.println("Insufficiant balance.");
            return false;
        }
    }

    @Override
    public void tax(double income){
        double tax = Math.max(0, taxable_income) * tax_rate;
        super.setBalance(super.getBalance()-tax);
    }

}
