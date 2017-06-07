import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeSet;

/**
 *Created by Saego on 07.06.2017.
 */
public class MainEfficiency {

    private LinkedList<String> linkedList;
    private ArrayList<String> arrayList;
    private TreeSet<String> treeSet;
    private Productivity productivity = new Productivity();
    private final static int DIV = 10;

    private MainEfficiency() {
        this.linkedList = new LinkedList<String>();
        this.arrayList = new ArrayList<String>();
        this.treeSet = new TreeSet<String>();
    }

    private void start(){
        int amount = 50000;
        long time;

        time = productivity.addElement(linkedList, amount);
        System.out.println("LinkedList");
        System.out.println("Time add = " + time + " [mks]");

        time = productivity.addElement(arrayList, amount);
        System.out.println("ArrayList");
        System.out.println("Time add = " + time + " [mks]");

        time = productivity.addElement(treeSet, amount);
        System.out.println("TreeSet");
        System.out.println("Time add = " + time + " [mks]");

        time = productivity.removeElement(linkedList, amount / DIV);
        System.out.println("LinkedList");
        System.out.println("Time remove = " + time + " [mks]");

        time = productivity.removeElement(arrayList, amount / DIV);
        System.out.println("ArrayList");
        System.out.println("Time remove = " + time + " [mks]");

        time = productivity.removeElement(treeSet, amount / DIV);
        System.out.println("TreeSet");
        System.out.println("Time remove = " + time + " [mks]");
    }

    public static void main(String []args){
        MainEfficiency mainEfficiency = new MainEfficiency();
        mainEfficiency.start();
    }
}
