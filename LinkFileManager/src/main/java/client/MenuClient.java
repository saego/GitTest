package client;

/**
 Created by ${Ruslan} on 31.01.17.
 */
public class MenuClient {
    private Input input;
    private Client client;
    private ClientAction []actions = new ClientAction[5];

    public MenuClient(Input input, Client client) {
        this.input = input;
        this.client = client;
    }

    //menu actions
    public void fillActions(){
        this.actions[0] = this.new EnterFolder();
        this.actions[1] = this.new DownloadFile();
        this.actions[2] = this.new SendFile();
        this.actions[3] = this.new ExitFolder();
        this.actions[4] = this.new Exit();
    }

    //selection menu
    void select(int key){
        this.actions[key].execute(this.input, this.client);
    }
    void show(){
        for (ClientAction action:
                this.actions){
            if (action != null){
                System.out.println(action.info());
            }
        }
    }

    //getting quantity of actions
    int []getAllActions(){
        int []actionsQuantity = new int[this.actions.length];
        int i = 0;
        for(int n = 0; n < actionsQuantity.length; n++){
            actionsQuantity[n] = i;
            i = i +1;
        }
        return actionsQuantity;
    }

    //enter folder, show folder and file list
    private class EnterFolder extends InfoAction{

        EnterFolder() {
            super("Show list");
        }

        public int key() {
            return 0;
        }

        public void execute(Input input, Client client) {

        }
    }

    //download file from sever
    private class DownloadFile extends InfoAction{
        DownloadFile() {
            super("Download file from server");
        }

        public int key() {
            return 1;
        }

        public void execute(Input input, Client client) {

        }
    }

    //send file to server
    private class SendFile extends InfoAction{

        SendFile() {
            super("Send file to server");
        }

        public int key() {
            return 2;
        }

        public void execute(Input input, Client client) {

        }
    }

    private class ExitFolder extends InfoAction{

        ExitFolder() {
            super("Exit from This folder");
        }

        public int key() {
            return 3;
        }
        public void execute(Input input, Client client) {

        }
    }

    private class Exit extends InfoAction{

        Exit() {
            super("Exit");
        }

        public int key() {
            return 4;
        }

        public void execute(Input input, Client client) {

        }
    }
}
