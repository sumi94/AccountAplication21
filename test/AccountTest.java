import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AccountTest{

    @Test
    public void shouldBeAbleAddTenRupeesToTheAccount() {
         Account account = new Account(0, null, null,null);
         account.addMoney(10d);
         assertEquals("10.0",account.toString());
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void negativeAmountShouldNotBeAdded() {
        expectedException.expect(IllegalInputException.class);
        expectedException.expectMessage("Negative amount can't be added");
        Account account = new Account(0, null, null,null);
        account.addMoney(-10);
    }

    @Test
    public void shouldBeAbleToWithdrawTenRupees() {
        Account account = new Account(10d, null, null,null);
        account.withdraw(10d);
        assertEquals("0.0",account.toString());
    }

//    @Test
//    public void shouldNotifyAccountHolderAndAuditorWhenMoreAmountIsWithdrawn() {
//
//        AccountHolder accountHolder = Mockito.mock(AccountHolder.class);
//        Auditor auditor = Mockito.mock(Auditor.class);
//        when(accountHolder.notifyByEmail(null, balance)).thenReturn(true);
//        when(auditor.notifyByEmail(null, balance)).thenReturn(true);
//        Account account = new Account(10d, accountHolder,auditor);
//        account.withdraw(20d);
//        verify(accountHolder).notifyByEmail(null, balance);
//        verify(auditor).notifyByEmail(null, balance);
//    }

    @Test
    public void shouldNotifyOwnerAndAuditor() {
        EmailNotifier emailNotifier = Mockito.mock(EmailNotifier.class);

        Account account = new Account(100.0,"ownersemail@gmail.com","auditoremail@gmail.com",emailNotifier);
        account.withdraw(200.0);
        verify(emailNotifier).notifyByEmail("ownersemail@gmail.com",-100.0);
        verify(emailNotifier).notifyByEmail("auditoremail@gmail.com",-100.0);

    }
}

