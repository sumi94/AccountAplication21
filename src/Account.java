public class Account {
    private double amount;
    private AccountHolder accountHolder;
    private Auditor auditor;

    public Account(double amount, AccountHolder accountHolder, Auditor auditor) {
        this.amount = amount;
        this.accountHolder = accountHolder;
        this.auditor = auditor;
    }



    public void addMoney(double addedAmount) {
        if(addedAmount<0)
            throw new IllegalInputException("Negative amount can't be added");
        amount = amount + addedAmount;
    }

    public void withdraw(double withdrawnAmount) {
        amount -= withdrawnAmount;
        if (amount < 0) {
            accountHolder.notifyByEmail();
            auditor.notifyByEmail();
        }

    }

    @Override
    public String toString()
    {
        return String.valueOf(amount);
    }
}
