package start;

import moduls.Comment;
import moduls.Item;

import java.util.Random;

/**
 Created by ${Ruslan} on 19.09.16.

 */
class Tracker {
    private Item[] items = new Item[1];
    private static final Random RN = new Random();

    Item addClient(Item item) {

        for (int i = 0; i < this.items.length; i++){
            if(this.items[i] == null){
                item.setClientId(this.generateClientId());
                this.items[i] = item;
                break;
            }
        }
        int itemsArrLength = 0;
        for (Item item1 : this.items) {
            if (item1 != null) {
                itemsArrLength++;
            }
        }
        if(itemsArrLength == this.items.length){
            Item []itemsTemp = new Item[this.items.length + 1];
            System.arraycopy(items, 0, itemsTemp, 0, this.items.length);
            this.items = itemsTemp;
        }
        return item;
    }

    Item findById(String clientId) {
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

    Item[] getAll() {

        return this.items;
    }

    private String generateClientId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }



    void remove(String clientId) {
        for (int i = 0; i < items.length; i++) {
            if (items[i].getClientId().equals(clientId)) {
                items[i] = null;
                break;
            }
        }
    }

    void rename(Item item) {
        for (int i = 0; i < items.length; i++) {
            if (items[i].getClientId().equals(item.getClientId())) {
                items[i] = item;
                break;
            }
        }
    }

    void addComment(Comment comment, String clientId){
        for (Item item:
             items) {
            if(item != null && item.getClientId().equals(clientId)){
                item.addComment(comment);
                break;
            }
        }
    }
}