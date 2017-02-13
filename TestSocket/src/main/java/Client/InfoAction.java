package Client;

/**
 * Created by Saego on 13.02.2017.
 */
public abstract class InfoAction implements ClientAction{
    private String name;

    public InfoAction(String name) {
        this.name = name;
    }

    public abstract int key();
    public void execute(Input input, ClientApp app){}

    public String info() {
        return String.format("%s. %s", this.key(), name);
    }


}
