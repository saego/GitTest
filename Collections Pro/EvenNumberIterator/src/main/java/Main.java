/**
 * Created by Saego on 23.06.2017.
 */
public class Main {

    public static void main(String[] arg) {
    IteratorEvenNumber it = new IteratorEvenNumber(new int[]{1, 4, 1, 3, 3, 7, 8, 3, 10, 1});
   /*
    while(it.hasNext()){
        System.out.println(it.next());
    }
    */
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.hasNext());
        System.out.println(it.hasNext());
        System.out.println(it.next());
        System.out.println(it.hasNext());
    }
}
