package start;

/**
  Created by Ruslan on 11.12.2016.
 */
class MenuOutException extends RuntimeException{
    //exception key out of range
    MenuOutException(String msg){
        super(msg);
    }
}
