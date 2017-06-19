import clientData.Account;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 *Created by Saego on 19.06.2017.
 */
public class AccountTest {
    private Account account = new Account(1234, 1238);
    @Test
    public void getMoneyValue() throws Exception {
        assertThat(account.getMoneyValue(), is(1234));
    }

    @Test
    public void setMoneyValue() throws Exception {
        account.setMoneyValue(1);
        assertThat(account.getMoneyValue(), is(1));
    }

    @Test
    public void getRequisites() throws Exception {
        long req = 1238;
        assertThat(account.getRequisites(), is(req));
    }

}