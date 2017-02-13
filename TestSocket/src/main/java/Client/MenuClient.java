package Client;

/**
 Created by Saego on 13.02.2017.
 */
public class MenuClient {
    private Input input;
    private ClientApp app;
    private ClientAction []clientAction = new ClientAction[3];

    public MenuClient(Input input, ClientApp app) {
        this.input = input;
        this.app = app;
    }

    void fillAction(){
        this.clientAction[0] = this.new EnterFolder();
        this.clientAction[1] = this.new ExitFolder();
        this.clientAction[3] = this.new ExitApp();
    }

    void select(int key){
        this.clientAction[key].execute(this.input, this.app);
    }

    //getting quantity of actions
    int []getAllActions(){
        int []actionsQuantity = new int[this.clientAction.length];
        int i = 0;
        for(int n = 0; n < actionsQuantity.length; n++){
            actionsQuantity[n] = i;
            i = i +1;
        }
        return actionsQuantity;
    }

    private class EnterFolder extends InfoAction{

        EnterFolder() {
            super("Enter folder");
        }

        public int key() {
            return 1;
        }

        public void execute(Input input, ClientApp app){

        }
    }

    private class ExitFolder extends InfoAction{

        ExitFolder() {
            super("Exit folder");
        }

        public int key() {
            return 2;
        }

        public void execute(Input input, ClientApp app){

        }
    }

    private class ExitApp extends InfoAction{

        ExitApp() {
            super("Exit");
        }

        public int key() {
            return 0;
        }

        public void execute(Input input, ClientApp app){

        }
    }
}
