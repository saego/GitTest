import java.util.*;

public class Linked {

    public static void main(String[] args) {


            TreeSet<String> states = new TreeSet<String>();

            states.add("Германия");
            states.add("Франция");
            states.add("Италия");
            states.add("Великобритания");
            System.out.println(states.first()); // получим первый - самый меньший элемент
            System.out.println(states.last()); // получим последний - самый больший элемент
            // получим поднабор от одного элемента до другого
            SortedSet<String> set = states.subSet("Великобритания", "Франция");
            System.out.println(set);
            // элемент из набора, который больше текущего
            String greater = states.higher("Германия");
        System.out.println(greater);
            // элемент из набора, который больше текущего
            String lower = states.lower("Германия");
        System.out.println(lower);
            // возвращаем набор в обратном порядке
            NavigableSet<String> navSet = states.descendingSet();
            // возвращаем набор в котором все элементы меньше текущего

            SortedSet<String> setLower=states.headSet("Германия");
            // возвращаем набор в котором все элементы больше текущего
            SortedSet<String> setGreater=states.tailSet("Германия");
        }
}