import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 Created by Saego on 10.06.2017.
 */
public class SortUserTest {

    private List<User> users = new ArrayList<User>();
    private Set<User> testUsr = new TreeSet<User>();
    private SortUser sortUser = new SortUser();

    @org.junit.Test
    public void sort() throws Exception {
        this.users.add(new User("Arsen", 34));
        this.users.add(new User("Tom", 12));
        this.users.add(new User("Johnathan", 3));
        this.users.add(new User("Panas", 68));
        this.testUsr.add(new User("Johnathan", 3));
        this.testUsr.add(new User("Tom", 12));
        this.testUsr.add(new User("Arsen", 34));
        this.testUsr.add(new User("Panas", 68));
        assertThat(sortUser.sort(this.users), is(testUsr));
    }

}