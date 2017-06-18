package clientData;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 Created by Saego on 18.06.2017.
 */
public class UserTest {
    private String name = "Eric";
    private String passportSerial = "ER";
    private Integer passportNumber = 1234;
    private User user = new User(name, new Passport(passportSerial, passportNumber));
    User testUser = new User("Eric", new Passport("ER", 1234));
    @org.junit.Test
    public void getName() throws Exception {
        assertThat(user.getName(), is("Eric"));
    }

    @org.junit.Test
    public void getPassport() throws Exception {
        assertThat(user.getPassport(), is(new Passport("ER", 1234)));
    }

    @org.junit.Test
    public void setName() throws Exception {
    }

    @org.junit.Test
    public void setPassport() throws Exception {
    }

}