package start;

import moduls.Item;
import org.junit.Test;

import static org.junit.Assert.*;


/**
 * Created by ${Ruslan} on 20.09.16.
 */
public class TrackerTest {
    Tracker tracker = new Tracker();

    @Test
    public void testAddClient() throws Exception {
        assertThat(tracker.addClient(new Item("Tom", 12, "repair iron")), is());
    }

    @Test
    public void testFindById() throws Exception {

    }
}