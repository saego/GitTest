package start;

import moduls.Item;

import java.util.Random;

/**
 Created by ${Ruslan} on 19.09.16.

 */
public class Tracker {
    private Item[] items = new Item[1];
    private int position = 0;
    private static final Random RN = new Random();

    public Item addClient(Item item) {
        item.setClientId(this.generateClientId());
        if (position >= items.length) {
            Item[] itemsTemp = new Item[items.length + 1];
            System.arraycopy(items, 0, itemsTemp, 0, items.length);
            items = itemsTemp;
        }
        this.items[position++] = item;
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
        Item[] res = new Item[position];
        for (int i = 0; i != this.position; i++) {
            res[i] = items[i];
        }
        return res;
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
}