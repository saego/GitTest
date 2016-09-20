package start;

import moduls.Item;

/**
 * Created by ${Ruslan} on 19.09.16.
 */
public class Tracker {
    private Item[] items = new Item[20];
    private int position = 0;

    public Item addClient(Item item){
        this.items[position++] = item;
        return item;
    }

    public Item findById(String clientId){
        Item res = null;
        for (Item item:
             items) {
            if (item != null && item.getClientId().equals(clientId)){
                res = item;
                break;
            }
        }
        return res;
    }
}
