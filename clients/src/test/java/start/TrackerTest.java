package start;

import moduls.Item;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;



/**
 Created by ${Ruslan} on 20.09.16.

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
        Item [] itemstest = new Item[3];
        itemstest[0] = new Item("Roma", 123, "repair irons");
        itemstest[1] = new Item("Ron", 12, "repair iron");
        itemstest[2] = new Item("Atilla", 13, "repair hairdryer");
        String []testClientIds = new String[3];
        int i = 0;
        for (Item itemtest:
                itemstest) {
            testClientIds[i] = tracker.addClient(itemtest).getClientId();
            i++;
        }
        assertThat(tracker.findById(testClientIds[2]), is(itemstest[2]));
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

    @Test
    public void testFindByName() throws Exception {
        Item []itemstest = new Item[3];
        itemstest[0] = new Item("Roma", 123, "repair irons");
        itemstest[1] = new Item("Ron", 12, "repair iron");
        itemstest[2] = new Item("Ron", 13, "repair hairdryer");
        for (Item itemtest:
                itemstest) {
            tracker.addClient(itemtest);
        }
        Item []check = new Item[2];
        int temp = 1;
        for(int i = 0; i < check.length; i++){
            check[i] = itemstest[temp];
            temp++;
        }
        itemstest = check;
        assertArrayEquals(tracker.findByName("Ron"), itemstest);
    }

    @Test
    public void testFindByDate() throws Exception {
        Item [] itemstest = new Item[3];
        itemstest[0] = new Item("Roma", 123, "repair irons");
        itemstest[1] = new Item("Ron", 126, "repair iron");
        itemstest[2] = new Item("Atilla", 13, "repair hairdryer");
        long []testData = new long[3];
        int i = 0;
        for (Item itemtest:
                itemstest) {
            testData[i] = tracker.addClient(itemtest).getDateAdd();
            i++;
        }
        assertThat(tracker.findByDate(testData[1]), is(itemstest[1]));
    }

    @Test
    public void testFindByDescription() throws Exception {
        Item []itemstest = new Item[3];
        itemstest[0] = new Item("Roma", 123, "repair iron");
        itemstest[1] = new Item("Ron", 12, "repair iron");
        itemstest[2] = new Item("Atilla", 13, "repair hairdryer");
        for (Item itemtest:
                itemstest) {
            tracker.addClient(itemtest);
        }
        Item []check = new Item[2];
        int temp = 0;
        for(int i = 0; i < check.length; i++){
            check[i] = itemstest[temp];
            temp++;
        }
        itemstest = check;
        assertArrayEquals(tracker.findByDescription("repair iron"), itemstest);
    }

    @Test
    public void testRemove() throws Exception {
        Item []itemstest = new Item[3];
        itemstest[0] = new Item("Roma", 123, "repair iron");
        itemstest[1] = new Item("Ron", 12, "repair iron");
        itemstest[2] = new Item("Atilla", 13, "repair hairdryer");
        tracker.remove(itemstest[2].getClientId());
        itemstest[2] = null;
        assertArrayEquals(tracker.getAll(), itemstest);
    }
}