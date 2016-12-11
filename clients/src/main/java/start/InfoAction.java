package start;

/**
 * Created by Ruslan on 11.12.2016.
 */
public abstract class InfoAction implements UserAction{
    String name;
    public InfoAction(String name) {
    this.name = name;
    }



    public abstract int key();

    public void execute(Input input, Tracker tracker) {

    }

    public String info() {
        return String.format("%s. %s", this.key(), name);
    }
}
