package start;

import moduls.Comment;
import moduls.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 Created by ${Ruslan} on 19.09.16.

 */
class Tracker {
    private List<Item> items = new ArrayList<Item>();
    private static final Random RN = new Random();

    Item addClient(Item item) {

        //for (int i = 0; i < this.items.size(); i++){
          //  if(this.items[i] == null){
                item.setClientId(this.generateClientId());
                this.items.add(item);
         //       break;
        //    }
        //}
        //int itemsArrLength = 0;
        //for (Item item1 : this.items) {
        //    if (item1 != null) {
        //        itemsArrLength++;
        //    }
        //}
        //if(itemsArrLength == this.items.length){
        //    Item []itemsTemp = new Item[this.items.length + 1];
        //    System.arraycopy(items, 0, itemsTemp, 0, this.items.length);
        //    this.items = itemsTemp;
        //}
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

    List<Item> getAll() {

        return this.items;
    }

    private String generateClientId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    /*public Item[] findByName(String clientName) {
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
    }*/

    void remove(String clientId) {
        /*for (int i = 0; i < items.length; i++) {
            if (items[i].getClientId().equals(clientId)) {
                items[i] = null;
                break;
            }
        }*/
        for (Item item:
             items) {
            if (item.getClientId().equals(clientId)){
                items.remove(item);
                break;
            }
        }
    }

    void rename(Item item) {
        /*for (int i = 0; i < items.length; i++) {
            if (items[i].getClientId().equals(item.getClientId())) {
                items[i] = item;
                break;
            }
        }*/
        for (Item idem:
             items) {
            if (idem.getClientId().equals(item.getClientId())){
                items.set(items.indexOf(idem), item);
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