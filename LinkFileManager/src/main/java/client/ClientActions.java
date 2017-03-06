package client;

/**
 * Created by Saego on 03.03.2017.
 */
public interface ClientActions {
    String commandName();
    public void execute(ToDo value);
}
