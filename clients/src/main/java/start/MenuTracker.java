package start;

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

    }
}
