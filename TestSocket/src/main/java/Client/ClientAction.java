package Client;

/**
 Created by Saego on 13.02.2017.
 */
public interface ClientAction {
    String command();
    void execute(Input input, ClientApp clientApp);
    String info();
}
