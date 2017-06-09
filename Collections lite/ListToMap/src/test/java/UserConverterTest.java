import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 *Created by Saego on 09.06.2017.
 */
public class UserConverterTest {
    private List<User> users = new ArrayList<User>();
    private UserConverter converter = new UserConverter();
    @org.junit.Test
    public void process() throws Exception {
        users.add(new User(12, "Roman", "Tokyo"));
        users.add(new User(3, "Tom", "New York"));
        users.add(new User(34, "Ann", "Amsterdam"));
        Map<Integer, User> testUsers = new HashMap<Integer, User>();
        testUsers.put(12, new User(12, "Roman", "Tokyo"));
        testUsers.put(3, new User(3, "Tom", "New York"));
        testUsers.put(34, new User(34, "Ann", "Amsterdam"));
        assertThat(converter.process(users), is(testUsers));
    }

}