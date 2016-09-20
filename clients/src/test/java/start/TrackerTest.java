package start;

import moduls.Item;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;



/**
 * Created by ${Ruslan} on 20.09.16.
 */
public class TrackerTest {
    Tracker tracker = new Tracker();

    @Test
    public void testAddClient() throws Exception {
        Item item = new Item("Ron", 123, "repair iron");
        assertThat(tracker.addClient(item), is(item));
    }

    @Test
    public void testFindById() throws Exception {

    }

    @Test
    public void testGetAll() throws Exception {
        Item item = new Item("Ron", 123, "repair iron");
        tracker.addClient(item);
    }
}