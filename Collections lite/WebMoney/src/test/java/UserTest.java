import clientData.Passport;
import clientData.User;

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
        user.setName("Nick");
        assertThat(user.getName(), is("Nick"));
    }

    @org.junit.Test
    public void setPassport() throws Exception {
        user.setPassport(new Passport("RE", 234));
        assertThat(user.getPassport(), is(new Passport("RE", 234)));
    }

}