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


}
