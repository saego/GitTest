package start;

import moduls.Comment;
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
        Item[] itemstest = new Item[3];
        itemstest[0] = new Item("Roma", 123, "repair irons");
        itemstest[1] = new Item("Ron", 12, "repair iron");
        itemstest[2] = new Item("Atilla", 13, "repair hairdryer");
        String[] testClientIds = new String[3];
        int i = 0;
        for (Item itemtest :
                itemstest) {
            testClientIds[i] = tracker.addClient(itemtest).getClientId();
            i++;
        }
        assertThat(tracker.findById(testClientIds[2]), is(itemstest[2]));
    }

    @Test
    public void testGetAll() throws Exception {
        Item[] itemstest = new Item[3];
        itemstest[0] = new Item("Roma", 123, "repair irons");
        itemstest[1] = new Item("Ron", 12, "repair iron");
        itemstest[2] = new Item("Atilla", 13, "repair hairdryer");
        for (Item itemtest :
                itemstest) {
            tracker.addClient(itemtest);
        }
        assertArrayEquals(getWithoutNull(tracker.getAll()), itemstest);
    }

    @Test
    public void testFindByName() throws Exception {
        Item[] itemstest = new Item[3];
        itemstest[0] = new Item("Roma", 123, "repair irons");
        itemstest[1] = new Item("Ron", 12, "repair iron");
        itemstest[2] = new Item("Ron", 13, "repair hairdryer");
        for (Item itemtest :
                itemstest) {
            tracker.addClient(itemtest);
        }
        Item[] check = new Item[2];
        int temp = 1;
        for (int i = 0; i < check.length; i++) {
            check[i] = itemstest[temp];
            temp++;
        }
        itemstest = check;
        assertArrayEquals(tracker.findByName("Ron"), itemstest);
    }

    @Test
    public void testFindByDate() throws Exception {
        Item[] itemstest = new Item[3];
        itemstest[0] = new Item("Roma", 123, "repair irons");
        itemstest[1] = new Item("Ron", 126, "repair iron");
        itemstest[2] = new Item("Atilla", 13, "repair hairdryer");
        long[] testData = new long[3];
        int i = 0;
        for (Item itemtest :
                itemstest) {
            testData[i] = tracker.addClient(itemtest).getDateAdd();
            i++;
        }
        assertThat(tracker.findByDate(testData[1]), is(itemstest[1]));
    }

    @Test
    public void testFindByDescription() throws Exception {
        Item[] itemstest = new Item[3];
        itemstest[0] = new Item("Roma", 123, "repair iron");
        itemstest[1] = new Item("Ron", 12, "repair iron");
        itemstest[2] = new Item("Atilla", 13, "repair hairdryer");
        for (Item itemtest :
                itemstest) {
            tracker.addClient(itemtest);
        }
        Item[] check = new Item[2];
        int temp = 0;
        for (int i = 0; i < check.length; i++) {
            check[temp] = itemstest[i];
            temp++;
        }
        itemstest = check;
        assertArrayEquals(tracker.findByDescription("repair iron"), itemstest);
    }

    @Test
    public void testRemove() throws Exception {
        Item[] itemstest = new Item[3];
        itemstest[0] = new Item("Roma", 123, "repair iron");
        itemstest[1] = new Item("Ron", 12, "repair iron");
        itemstest[2] = new Item("Atilla", 13, "repair hairdryer");
        for (Item itemtest :
                itemstest) {
            tracker.addClient(itemtest);
        }
        tracker.remove(itemstest[2].getClientId());
        itemstest[2] = null;
        Item[] itemstest1 = new Item[2];
        int temp = 0;
        for (Item anItemstest : itemstest) {
            if (anItemstest != null) {
                itemstest1[temp] = anItemstest;
                temp++;
            }
        }
        itemstest = itemstest1;
        assertArrayEquals(getWithoutNull(tracker.getAll()), itemstest);
    }

    @Test
    public void testRename() throws Exception {
        Item[] itemstest = new Item[3];
        itemstest[0] = new Item("Roma", 123, "repair iron");
        itemstest[1] = new Item("Ron", 12, "repair iron");
        itemstest[2] = new Item("Atilla", 13, "repair hairdryer");
        for (Item itemtest :
                itemstest) {
            tracker.addClient(itemtest);
        }
        itemstest[1].setName("Vik");
        itemstest[1].setDateAdd(321);
        itemstest[1].setDescription("broken lamp");
        tracker.rename(itemstest[1]);
        assertArrayEquals(getWithoutNull(tracker.getAll()), itemstest);

    }

    @Test
    public void testAddComment() throws Exception {
        Item[] itemstest = new Item[3];
        itemstest[0] = new Item("Roma", 123, "repair iron");
        itemstest[1] = new Item("Ron", 12, "repair iron");
        itemstest[2] = new Item("Atilla", 13, "repair hairdryer");
        for (Item itemtest :
                itemstest) {
            tracker.addClient(itemtest);
        }
        Comment[]comments = new Comment[3];
        comments[0] = new Comment("comment 1");
        comments[1] = new Comment("comment 2");
        comments[2] = new Comment("comment 3");
        tracker.addComment(comments[0], itemstest[0].getClientId());
        tracker.addComment(comments[1], itemstest[0].getClientId());
        tracker.addComment(comments[2], itemstest[2].getClientId());
        assertArrayEquals(getWithoutNull(tracker.getAll()), itemstest);
    }

    public Item[] getWithoutNull(Item []getAllItems){
        int lengthArrWithoutNull = 0;
        for (Item getAllItem:
             getAllItems) {
            if(getAllItem != null){
                lengthArrWithoutNull++;
            }
        }
        Item[] itemsWitoutNull = new Item[lengthArrWithoutNull];
        int temp = 0;
        for (Item getAllItem : getAllItems) {
            if (getAllItem != null) {
                itemsWitoutNull[temp] = getAllItem;
                temp++;
            }
        }
        return itemsWitoutNull;
    }
}