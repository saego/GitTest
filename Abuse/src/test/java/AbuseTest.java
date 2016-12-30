import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 Created by ${Ruslan} on 30.12.16.
 */
public class AbuseTest {
    private String []abuses = new String[]{"abu", "nabu", "apu"};
    private InputStream iS = new ByteArrayInputStream("efbuwbqefu iubweufbewu uwehfuwehf nabu wifiw abu ienfiwenf apu".getBytes());
    private OutputStream os = new ByteArrayOutputStream();
    private Abuse abuse = new Abuse();

    @org.junit.Test
    public void dropAbuses() throws Exception {
        abuse.dropAbuses(iS, os, abuses);
        String test = "efbuwbqefu iubweufbewu uwehfuwehf wifiw ienfiwenf ";
        assertThat(os.toString(), is(test));
    }

}