public class SavingsAccount extends Account{
    private final static double withdraw_fee = 5.00;

    public SavingsAccount(String id, String name, double balance) {
        super(id, name, balance);
    }

    public SavingsAccount(SavingsAccount source) {
        super(source);
    }

    @Override
    public Account clone() {
        return new SavingsAccount(this);
    }

    @Override
    public void debit (double amount) {
        super.setBalance(super.getBalance()+amount);
    }

    @Override
    public boolean credit (double amount) {
        if ((amount+withdraw_fee) <= super.getBalance()) {
            super.setBalance(super.getBalance()-amount-withdraw_fee);
            return true;
        }
        else {
            System.out.println("Insufficient amount.");
            return false;
        }
    }

}
