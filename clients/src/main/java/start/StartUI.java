package start;

import moduls.*;

/**
 Created by ${Ruslan} on 04.10.16.

 */
public class StartUI {
    Tracker tracker = new Tracker();
    public static void main(String[] args) {
        StartUI start = new StartUI();
        start.addClients();
        start.searchClients();
    }
        private void addClients(){

            Item[] items = new Item[6];
        items[0] = new Item("Oxana", 1, "description 1");
        items[1] = new Item("Owen", 2, "description 2");
        items[2] = new Item("Mike", 3, "description 3");
        items[3] = new Item("Nick", 4, "description 4");
        items[4] = new Item("Mike", 5, "description 5");
        items[5] = new Item("Johnathan", 6, "description 6");

            System.out.println("                                       " +
                    " ______/Add clients and show all clients/______");
            for (Item item:
                 items) {
                tracker.addClient(item);
            }
            System.out.println();
            System.out.println("________* Client Base *________");
            System.out.println();
            for (Item trackerItems:
                 tracker.getAll()) {
                if(trackerItems != null){
                    System.out.println("Client Id: " + trackerItems.getClientId()
                            + "   Client name: " + trackerItems.getName()
                            + "   Date add: " + trackerItems.getDateAdd()
                            + "   Description: " + trackerItems.getDescription());
                    System.out.println("*-*-*");
                }
            }
        }

        private void searchClients(){

        }
}
