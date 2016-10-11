package start;

import moduls.Item;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;

import static org.junit.Assert.*;

/**
 Created by ${Ruslan} on 11.10.16.

 */
public class InnerMenuTest {

    Tracker tracker  = new Tracker();
    StartUIConsole start = new StartUIConsole();
    Date date = new Date();

    @Test
    public void testSearchByName() throws Exception {
        Item[] items = new Item[3];
        items[0] = new Item("name0", date.getTime(), "description0");
        items[1] = new Item("name1", date.getTime(), "description1");
        items[2] = new Item("name2", date.getTime(), "description2");
        for (Item item:
             items) {
            tracker.addClient(item);
        }
        String testName = "name2";

    }

    @Test
    public void testSearchByDescription() throws Exception {

    }
}