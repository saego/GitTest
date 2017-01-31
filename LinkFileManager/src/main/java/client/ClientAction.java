package client;

/**
 * Created by ${Ruslan} on 31.01.17.
 */
public interface ClientAction {
    int key();
    void execute(Input input, Client client);
}
