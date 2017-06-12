import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 *Created by Saego on 12.06.2017.
 */
public class SortUserTest {

    private SortUser sortUser = new SortUser();
    private List<User> users = new ArrayList<User>();
    private List<User> testUsers1 = new ArrayList<User>();
    private List<User> testUsers2 = new ArrayList<User>();

    /**
     * Test unsorted list to sorted by name length.
     * @throws Exception
     */
    @org.junit.Test
    public void sortByNameLength() throws Exception {
        users.addAll(
                Arrays.asList(
                    new User("Athena", 14),
                    new User("Johnathan", 4),
                    new User("Roman", 45)
                )
        );
        testUsers1.addAll(
                Arrays.asList(
                        new User("Roman", 45),
                        new User("Athena", 14),
                        new User("Johnathan", 4)
                )
        );
        assertThat(sortUser.sortByNameLength(users), is(testUsers1));
    }

    @Test
    public void sortByAllFields() throws Exception {
        users.addAll(
                Arrays.asList(
                        new User("Athena", 14),
                        new User("Johnathan", 4),
                        new User("Roman", 45),
                        new User("Roman", 12)
                )
        );
        testUsers2.addAll(
                Arrays.asList(
                        new User("Athena", 14),
                        new User("Johnathan", 4),
                        new User("Roman", 12),
                        new User("Roman", 45)
                )
        );
    assertThat(sortUser.sortByAllFields(users), is(testUsers2));
    }
}
