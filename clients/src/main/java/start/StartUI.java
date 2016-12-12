package start;

/**
 Created by ${Ruslan} on 04.10.16.

 */
public class StartUI {
    private Input input;
    //private int[] range = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};

    private StartUI(Input input) {
        this.input = input;
    }

    private void start() {
        Tracker tracker = new Tracker();
        MenuTracker menuTracker = new MenuTracker(this.input, tracker);
        menuTracker.fillAction();
        int key;
        do {
            menuTracker.show();
            key = this.input.inputData("Select: ", menuTracker.getAllActions());
            menuTracker.select(key);
        }
        while (key != 8);
    }

    public static void main(String[] args) {
        Input input = new ValidateInput();
        new StartUI(input).start();
    }
}

