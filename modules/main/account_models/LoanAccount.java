public class LoanAccount extends Account{
    private final static double debt_limitation = -10000.0;
    private final static double interest_rate = 0.02;

    public LoanAccount(String id, String name, double balance) {
        super(id, name, balance);
    }

    public LoanAccount(LoanAccount source){
        super(source);
    }

    @Override
    public Account clone() {
        return new LoanAccount(this);
    }

    @ Override
    public void debit(double amount) {
        super.setBalance(super.getBalance()+amount);
    }

    @ Override
    public boolean credit(double amount) {
        if (super.getBalance() < debt_limitation) {
            System.out.println("Exceeded available withdraw amount.");
            return false;
        }
        else{
            super.setBalance(super.getBalance() - (1+interest_rate) * amount);
            return true;
        }
    }
    
    
}
