public class Auditor implements EmailNotifier{
    private String emailID;

    public Auditor(String emailID) {

        this.emailID = emailID;
    }

    public boolean notifyByEmail() {
        return true;
    }
}
