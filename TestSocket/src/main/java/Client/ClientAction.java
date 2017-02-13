package Client;

/**
 Created by Saego on 13.02.2017.
 */
public interface ClientAction {
    int key();
    void execute(Input input, ClientApp clientApp);
    String info();
}
