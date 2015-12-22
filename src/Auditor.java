public class Auditor implements EmailNotifier{
    private String emailID;

    public Auditor(String emailID) {

        this.emailID = emailID;
    }

    public boolean notifyByEmail(String emailId, double balance) {
        return true;
    }
}
