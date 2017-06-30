package Store;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 *Created by Saego on 30.06.2017.
 */
public class UserStoreTest {

    private UserStore<User> users = new UserStore<User>();
    private List<User> testUser = new ArrayList<User>();
    private int position;

    private void testListCreate(){
        testUser.add(new User("12", "Alex", 25));
        testUser.add(new User("13", "Johnathan", 12));
        testUser.add(new User("37", "Ann", 19));
        testUser.add(new User("4", "Susan", 7));
        testUser.add(new User("1", "Cony", 33));
    }
    @Test
    public void add() throws Exception {
        this.users.add(new User("12", "Alex", 25));
        this.users.add(new User("13", "Johnathan", 12));
        this.users.add(new User("37", "Ann", 19));
        this.users.add(new User("4", "Susan", 7));
        this.users.add(new User("1", "Cony", 33));
        testListCreate();
        assertThat(this.users.getObjects(), is(testUser.toArray()));
    }

    @Test
    public void add1() throws Exception {
        testListCreate();
        this.users.add(new User("12", "Alex", 25));
        this.users.add(new User("13", "Johnathan", 12));
        this.users.add(new User("37", "Ann", 19));
        this.users.add(new User("1", "Cony", 33));
        position = 3;
        this.users.add(position, new User("4", "Susan", 7));
        assertThat(this.users.getObjects(), is(testUser.toArray()));
    }

    @Test
    public void removeByPosition() throws Exception {
        testListCreate();
        this.users.add(new User("12", "Alex", 25));
        this.users.add(new User("13", "Johnathan", 12));
        this.users.add(new User("37", "Ann", 19));
        this.users.add(new User("1", "Lassa", 33));      //will be removed
        this.users.add(new User("4", "Susan", 7));
        this.users.add(new User("1", "Cony", 33));
        position = 3;
        this.users.remove(position);
        assertThat(this.users.getObjects(), is(testUser.toArray()));
    }

    @Test
    public void remove1() throws Exception {
        testListCreate();
        this.users.add(new User("12", "Alex", 25));
        this.users.add(new User("13", "Johnathan", 12));
        this.users.add(new User("37", "Ann", 19));
        this.users.add(new User("1", "Lassa", 33));      //will be removed
        this.users.add(new User("4", "Susan", 7));
        this.users.remove(new User("1", "Lassa", 33));
        this.users.add(new User("1", "Cony", 33));
        assertThat(this.users.getObjects(), is(testUser.toArray()));
    }

    @Test
    public void set() throws Exception {
        testListCreate();
        this.users.add(new User("12", "Alex", 25));
        this.users.add(new User("13", "Johnathan", 12));
        this.users.add(new User("47", "Ron", 11));
        this.users.add(new User("4", "Susan", 7));
        this.users.add(new User("1", "Cony", 33));
        position = 2;
        this.users.set(position, new User("37", "Ann", 19));
        assertThat(this.users.getObjects(), is(testUser.toArray()));
    }

    @Test
    public void set1() throws Exception {
        testListCreate();
        this.users.add(new User("12", "Alex", 25));
        this.users.add(new User("13", "Johnathan", 12));
        this.users.add(new User("47", "Ron", 11));
        this.users.add(new User("4", "Susan", 7));
        this.users.add(new User("1", "Cony", 33));
        this.users.set(new User("47", "Ron", 11), new User("37", "Ann", 19));
        assertThat(this.users.getObjects(), is(testUser.toArray()));
    }

    @Test
    public void getObjects() throws Exception {
        this.users.add(new User("12", "Alex", 25));
        this.users.add(new User("13", "Johnathan", 12));
        this.users.add(new User("37", "Ann", 19));
        this.users.add(new User("4", "Susan", 7));
        this.users.add(new User("1", "Cony", 33));
        testListCreate();
        assertThat(this.users.getObjects(), is(testUser.toArray()));
    }

}