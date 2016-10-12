package start;

/**
 Created by ${Ruslan} on 12.10.16.

 */
public class StubInput {

    public interface Input{
        String read();
    }
   // private Input io;

  //  public StubInput(final Input io){
    //    this.io = io;
    //}

    public interface Output{
        void println(Object value);
    }

    public interface IO extends Input, Output{

    }

    private IO io;

    public StubInput (final IO io){
        this.io = io;
    }
}
