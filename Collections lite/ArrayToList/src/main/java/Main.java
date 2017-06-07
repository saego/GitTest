/**
 * Created by Saego on 07.06.2017.
 */
public class Main {

    public  static void main(String []args){
        int [][]test = {
                {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
        };
        Transformator transformator = new Transformator();
        transformator.toList(test);
    }
}
