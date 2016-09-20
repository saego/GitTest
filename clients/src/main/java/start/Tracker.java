package start;

import moduls.Item;

import java.util.Random;

/**
 * Created by ${Ruslan} on 19.09.16.
 */
public class Tracker {
    private Item[] items = new Item[20];
    private int position = 0;
    private static final Random RN = new Random();

    public Item addClient(Item item){
        item.setClientId(this.generateClientId());
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

    public Item[] getAll(){
        Item[] res = new Item[position];
        for (int i = 0; i != this.position; i++){
            res[i] = items[i];
        }
        return  res;
    }

    String generateClientId(){
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
}
