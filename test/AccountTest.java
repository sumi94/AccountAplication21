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
         Account account = new Account(0, null);
         account.addMoney(10d);
         assertEquals("10.0",account.toString());
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void negativeAmountShouldNotBeAdded() {
        expectedException.expect(IllegalInputException.class);
        expectedException.expectMessage("Negative amount can't be added");
        Account account = new Account(0, null);
        account.addMoney(-10);
    }

    @Test
    public void shouldBeAbleToWithdrawTenRupees() {
        Account account = new Account(10d, null);
        account.withdraw(10d);
        assertEquals("0.0",account.toString());
    }

    @Test
    public void shouldNotifyWhenMoreAmountIsWithdrawn() {

        Owner owner = Mockito.mock(Owner.class);
        when(owner.notifyByEmail()).thenReturn(true);

        Account account = new Account(10d, owner);
        account.withdraw(20d);

        verify(owner).notifyByEmail();
    }


}
