package Templates;

/**
  Created by Ruslan on 11.12.2016.
 */
public abstract class TemplateAction {
    public TemplateAction(String name){

    }
    void start(){

    }
    void finish(){

    }
    public void work(){
        this.start();
        this.finish();
    }
    public static void main(String []args){
        new
                TemplateAction("Name"){
            public void start(){

            }
            public void finish(){

            }
                };
    }

}
