package server;

import java.io.IOException;

/**
 * Created by Saego on 16.02.2017.
 */
public interface ServerActions {

    String commandName();

    public void execute() throws IOException;
}
