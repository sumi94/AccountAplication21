public class Account {
    private double balance;
    private String ownersEmailId;
    private String auditorEmailId;
    private EmailNotifier emailNotifier;



    public Account(double amount, String ownersEmailId, String auditorEmailId, EmailNotifier emailNotifier) {
        this.balance = amount;
        this.ownersEmailId = ownersEmailId;
        this.auditorEmailId = auditorEmailId;
        this.emailNotifier = emailNotifier;
    }


    public void addMoney(double addedAmount) {
        if(addedAmount<0)
            throw new IllegalInputException("Negative amount can't be added");
        balance = balance + addedAmount;
    }

    public void withdraw(double withdrawnAmount) throws EmailFailureException {
        balance -= withdrawnAmount;
        if (balance < 0) {
            if(!emailNotifier.notifyByEmail(ownersEmailId,balance) ||
                    !emailNotifier.notifyByEmail(auditorEmailId,balance))
                throw new EmailFailureException("Email Sending Failed !!");
        }

    }

    @Override
    public String toString()
    {
        return String.valueOf(balance);
    }
}
