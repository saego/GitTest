package client;

import java.io.IOException;

/**
 Created by Saego on 03.03.2017.
 */
public interface ClientActions {
    //String commandName();
    void execute(ToDo value) throws IOException;
}
