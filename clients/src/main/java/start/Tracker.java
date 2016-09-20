package start;

import moduls.Item;

/**
 * Created by ${Ruslan} on 19.09.16.
 */
public class Tracker {
    private Item[] item = new Item[20];
    private int position = 0;

    public Item addClient(Item item){
        this.item[position++] = item;
        return item;
    }
}
