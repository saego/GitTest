package stringin;

/**
 * Created by Ruslan on 03.08.2016.
 */
public class StringIn {
    String sub;
    String origin;
    public boolean contains(String sub, String origin){
        //boolean flagCont = false;
        char []subChar = sub.toCharArray();
        char []originChar = origin.toCharArray();
        if(subChar.length > originChar.length){
        return false;}

        return true;
    }
}
