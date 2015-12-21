public class AccountHolder implements EmailNotifier{
    private String emailId;

    public AccountHolder (String emailId) {

        this.emailId = emailId;
    }

    public boolean notifyByEmail() {
          return true;
    }
}
