public class Account {
    private double amount;
    private Owner owner;

    public Account(double amount, Owner owner) {
        this.amount = amount;
        this.owner = owner;
    }

    public void addMoney(double addedAmount) {
        if(addedAmount<0)
            throw new IllegalInputException("Negative amount can't be added");
        amount = amount + addedAmount;
    }

    public void withdraw(double withdrawnAmount) {
        amount -= withdrawnAmount;
        if(amount < 0) {
            owner.notifyByEmail();
        }
    }

    @Override
    public String toString()
    {
        return String.valueOf(amount);
    }
}
