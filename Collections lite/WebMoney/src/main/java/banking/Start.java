package banking;

/**
 *Created by Saego on 13.06.2017.
 */
public class Start {
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        TrackerMenu trackerMenu = new TrackerMenu(input, tracker);
        trackerMenu.initMenu();
        trackerMenu.start();
    }
}
