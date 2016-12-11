package start;

/**
  Created by Ruslan on 25.10.2016.
 */
public interface UserAction {
    int key();
    void execute(Input input, Tracker tracker);
    String info();
}
