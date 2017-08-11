package Map;

import SimpleList.Person;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Saego on 10.08.2017.
 */
public class SimpleHasMapTest {
    private Person person0 = new Person("Johnathan", 6);
    private Person person1 = new Person("Nil", 23);
    private Person person2 = new Person("Sonja", 32);
    private Person person3 = new Person("Niko", 17);
    private Person person4 = new Person("Hitman", 33);
    private Person person5 = new Person("Bob", 21);
    private Person person6 = new Person("Eric", 13);
    private Person person7 = new Person("Ruslan", 28);
    private Person person8 = new Person("Victoria", 15);
    private Person person9 = new Person("Ben", 53);
    private Person person10 = new Person("William", 33);
    private Person person11 = new Person("Filip", 24);
    private Person person12 = new Person("Ronald", 41);

    private SimpleHasMap<Person, Integer> map = new SimpleHasMap<Person, Integer>();
        private int number0 = 1;
        private int number1 = 2;
        private int number2 = 3;
        private int number3 = 4;
    @Test
    public void put() throws Exception {
        map.put(person1, number1);
        map.put(person2, number2);
        map.put(person3, number3);
        assertThat(map.put(person0, number0), is(true));

    }

    @Test
    public void getValue() throws Exception {
        map.put(person0, number0);
        map.put(person1, number1);
        map.put(person2, number2);
        map.put(person3, number3);
        int p = map.getValue(new Person("Johnathan", 6));
        assertThat(p, is(1));
    }

    @Test
    public void removeNode() throws Exception {
    }

    @Test
    public void iterator() throws Exception {
    }

}