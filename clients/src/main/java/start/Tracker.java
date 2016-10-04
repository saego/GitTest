package start;

import moduls.Comment;
import moduls.Item;

import java.util.Random;

/**
 Created by ${Ruslan} on 19.09.16.

 */
public class Tracker {
    private Item[] items = new Item[1];
   // private int position = 0;
    private static final Random RN = new Random();

    public Item addClient(Item item) {
    /*    item.setClientId(this.generateClientId());
        if (position >= items.length) {
            Item[] itemsTemp = new Item[items.length + 1];
            System.arraycopy(items, 0, itemsTemp, 0, items.length);
            items = itemsTemp;
        }
        this.items[position++] = item;*/
        for (int i = 0; i < items.length; i++){
            if(items[i] == null){
                item.setClientId(this.generateClientId());
                items[i] = item;
                break;
            }
        }
        int itemsArrLength = 0;
        for (Item item1 : items) {
            if (item1 != null) {
                itemsArrLength++;
            }
        }
        if(itemsArrLength == items.length){
            Item []itemsTemp = new Item[items.length + 1];
            System.arraycopy(items, 0, itemsTemp, 0, items.length);
            items = itemsTemp;
        }
        return item;
    }

    public Item findById(String clientId) {
        Item res = null;
        for (Item item :
                items) {
            if (item != null && item.getClientId().equals(clientId)) {
                res = item;
                break;
            }
        }
        return res;
    }

    public Item[] getAll() {
        /*Item[] res = new Item[];
        for (int i = 0; i != this.position; i++) {
            res[i] = items[i];
        } */
        return items;
    }

    String generateClientId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    public Item[] findByName(String clientName) {
        int quantity = 0;
        for (Item item :
                items) {
            if (item != null && item.getName().equals(clientName)) {
                quantity++;
            }
        }
        Item[] res = new Item[quantity];
        int index = 0;
        for (Item item :
                items) {
            if (item != null && item.getName().equals(clientName)) {
                res[index] = item;
                index++;
            }
        }
        return res;
    }

    public Item findByDate(long dateAdd) {
        Item res = null;
        for (Item item :
                items) {
            if (item != null && item.getDateAdd() == dateAdd) {
                res = item;
                break;
            }
        }
        return res;
    }

    public Item[] findByDescription(String description) {
        int quantity = 0;
        for (Item item :
                items) {
            if (item != null && item.getDescription().equals(description)) {
                quantity++;
            }
        }
        Item[] res = new Item[quantity];
        int index = 0;
        for (Item item :
                items) {
            if (item != null && item.getDescription().equals(description)) {
                res[index++] = item;
            }
        }
        return res;
    }

    public void remove(String clientId) {
        for (int i = 0; i < items.length; i++) {
            if (items[i].getClientId().equals(clientId)) {
                items[i] = null;
                break;
            }
        }
    }

    public void rename(Item item) {
        for (int i = 0; i < items.length; i++) {
            if (items[i].getClientId().equals(item.getClientId())) {
                items[i] = item;
                break;
            }
        }
    }

    public void addComment(Comment comment, String clientId){
        for (Item item:
             items) {
            if(item != null && item.getClientId().equals(clientId)){
                item.addComment(comment);
                break;
            }
        }
    }
}