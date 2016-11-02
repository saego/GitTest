package start;

import moduls.Item;

/**
 * Created by Ruslan on 25.10.2016.
 */
public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private UserAction []actions = new UserAction[8];

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init(){

    }

    private class AddItem implements UserAction{
        public int key(){
            return 0;
        }
        public void execute(Input input, Tracker tracker){
            String name = input.inputData("Input name please");
            String description = input.inputData("Input description please");
            tracker.addClient(new Item(name,333, description)); //тут нужно сделать нью дата
        }
        public String info(){
            return String.format("%s. %s", this.key(), "Adding new item");
        }
    }
}
