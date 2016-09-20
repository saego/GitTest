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
        Item []itemstest = new Item[3];
        itemstest[0] = new Item("Roma", 123, "repair irons");
        itemstest[1] = new Item("Ron", 12, "repair iron");
        itemstest[2] = new Item("Atilla", 13, "repair hairdryer");
        for (Item itemtest:
             itemstest) {
            tracker.addClient(itemtest);
        }
        assertArrayEquals(tracker.getAll(), itemstest);


    }
}