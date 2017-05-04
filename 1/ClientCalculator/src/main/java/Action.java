/**
 *Created by Saego on 04.05.2017.
 */
public interface Action {
    /**
     * Name of operation.
     * @return - name.
     */
    String actionName();

    /**
     * Info about action.
     * @return - info.
     */
    String actionInfo();

    /**
     * Do action.
     */
    void execute();
}
