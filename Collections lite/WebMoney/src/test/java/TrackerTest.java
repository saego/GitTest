import banking.Tracker;
import clientData.Account;
import clientData.Passport;
import clientData.User;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 Created by Saego on 19.06.2017.
 */
public class TrackerTest {
    private Tracker tracker = new Tracker();
    private User user1 = new User("Tory", new Passport("RT", 123));
    private User user2 = new User("Lena", new Passport("PW", 123));

    @Test
    public void addClient() throws Exception {
        tracker.addClient(user1);
        tracker.addClient(user2);
        Set<User> users = new HashSet<User>();
        users.add(user1);
        users.add(user2);
        assertThat(tracker.getAllClients(), is(users));
    }

    @Test
    public void getAllClients() throws Exception {
        tracker.addClient(user1);
        tracker.addClient(user2);
        Set<User> users = new HashSet<User>();
        users.add(user1);
        users.add(user2);
        assertThat(tracker.getAllClients(), is(users));
    }

    @Test
    public void addAccount() throws Exception {
        tracker.addClient(user1);
        tracker.addClient(user2);
        Account account = new Account(220, 333);
        tracker.addAccount(user2, account);
        long req = 333;
        assertThat(tracker.getAccount(user2, req), is(new Account(220, 333)));
    }

    @Test
    public void removeClient() throws Exception {
        tracker.addClient(user1);
        tracker.addClient(user2);
        tracker.removeClient(user1);
        Set<User> users = new HashSet<User>();
        users.add(user2);
        assertThat(tracker.getAllClients(), is(users));
    }

    @Test
    public void removeAccount() throws Exception {
        tracker.addClient(user1);
        tracker.addClient(user2);
        Account account = new Account(220, 333);
        Account account1 = new Account(330, 334);
        Account account2 = new Account(444, 555);
        tracker.addAccount(user2, account);
        tracker.addAccount(user2, account1);
        tracker.addAccount(user2, account2);
        tracker.removeAccount(user2, account);
        List<Account> accounts = new ArrayList<Account>();
        accounts.add(account1);
        accounts.add(account2);
        assertThat(tracker.clientAccounts(user2), is(accounts));
    }

    @Test
    public void clientAccounts() throws Exception {
        tracker.addClient(user1);
        tracker.addClient(user2);
        Account account = new Account(220, 333);
        Account account1 = new Account(330, 334);
        Account account2 = new Account(444, 555);
        tracker.addAccount(user1, account);
        tracker.addAccount(user1, account1);
        tracker.addAccount(user1, account2);
        List<Account> accounts = new ArrayList<Account>();
        accounts.add(account);
        accounts.add(account1);
        accounts.add(account2);
        assertThat(tracker.clientAccounts(user1), is(accounts));
    }

    @Test
    public void transferMoney() throws Exception {
        tracker.addClient(user1);
        tracker.addClient(user2);
        Account account = new Account(220, 333);
        Account account1 = new Account(330, 334);
        Account account2 = new Account(444, 555);
        tracker.addAccount(user1, account);
        tracker.addAccount(user2, account1);
        tracker.addAccount(user1, account2);
        tracker.transferMoney(user1, account2, user2,account1,10);
        assertThat(tracker.getAccount(user1, 555).getMoneyValue(), is(434));
        assertThat(tracker.getAccount(user2, 334).getMoneyValue(), is(340));
    }

    @Test
    public void getUsrByPassport() throws Exception {
        tracker.addClient(user1);
        tracker.addClient(user2);
        Account account = new Account(220, 333);
        Account account1 = new Account(330, 334);
        Account account2 = new Account(444, 555);
        tracker.addAccount(user1, account);
        tracker.addAccount(user2, account1);
        tracker.addAccount(user1, account2);
        assertThat(tracker.getUsrByPassport(new Passport("RT", 123)), is(user1) );
    }

    @Test
    public void getAccount() throws Exception {
        tracker.addClient(user1);
        tracker.addClient(user2);
        Account account = new Account(220, 333);
        Account account1 = new Account(330, 334);
        Account account2 = new Account(444, 555);
        tracker.addAccount(user1, account);
        tracker.addAccount(user1, account1);
        tracker.addAccount(user1, account2);
        long req = 334;
        assertThat(tracker.getAccount(user1, req), is(new Account(330, 334)));
    }

    @Test
    public void updateUser() throws Exception {
        tracker.addClient(user1);
        tracker.addClient(user2);
        Account account = new Account(220, 333);
        Account account1 = new Account(330, 334);
        Account account2 = new Account(444, 555);
        tracker.addAccount(user1, account);
        tracker.addAccount(user1, account1);
        tracker.addAccount(user1, account2);
        User user = new User("Ruslan", new Passport("MM", 123));
        tracker.updateUser(user2, user);
        Set<User> users = new HashSet<User>();
        users.add(user);
        users.add(user1);
        assertThat(new HashSet<User>(tracker.getAllClients()), is(users));
    }

}