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

                item.setClientId(this.generateClientId());
                this.items.add(item);
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


    void remove(String clientId) {
        for (Item item:
             items) {
            if (item.getClientId().equals(clientId)){
                items.remove(item);
                break;
            }
        }
    }

    void rename(Item item) {
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