package client;

/**
 Created by ${Ruslan} on 31.01.17.
 */
public abstract class InfoAction implements ClientAction{
    private String name;

    public InfoAction(String name) {
        this.name = name;
    }

    public abstract int key();

    public void execute(Input input, Client client) {}

    public String info() {
        return String.format("%s. %s", this.key(), name);
    }
}
