package Map;

import SimpleList.Person;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

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
    private Person person13 = new Person("Regina", 22);

    private SimpleHasMap<Person, Integer> map = new SimpleHasMap<>();

    private int number0 = 1;
    private int number1 = 2;
    private int number2 = 3;
    private int number3 = 4;
    private int number4 = 5;
    private int number5 = 6;
    private int number6 = 7;
    private int number7 = 8;
    private int number8 = 9;
    private int number9 = 10;
    private int number10 = 11;
    private int number11 = 12;
    private int number12 = 13;
    private int number13 = 14;

    @Test
    public void put() throws Exception {
        map.put(person1, number1);
        map.put(person2, number2);
        map.put(person3, number3);
        assertThat(map.put(person0, number0), is(true));
        map.put(person4, number4);
        map.put(person5, number5);
        map.put(person6, number6);
        map.put(person7, number7);
        map.put(person8, number8);
        map.put(person9, number9);
        map.put(person10, number10);
        map.put(person11, number11);
        map.put(person12, number12);
        map.put(person13, number13);
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
        map.put(person1, number1);
        map.put(person2, number2);
        map.put(person3, number3);
        map.put(person0, number0);
        map.put(person4, number4);
        map.put(person5, number5);
        map.put(person6, number6);
        map.put(person7, number7);
        map.put(person8, number8);
        map.put(person9, number9);
        map.put(person10, number10);
        map.put(person11, number11);
        map.put(person12, number12);
        map.put(person13, number13);
        map.removeNode(person11);
        map.removeNode(person3);
        assertNull(map.getValue(new Person("Niko", 17)));
        assertNull(map.getValue(person11));
    }

    @Test
    public void iterator() throws Exception {
        map.put(person0, number0);
        map.put(person1, number1);
        map.put(person2, number2);
        map.put(person3, number3);
        Iterator<Person> iterator = map.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.hasNext(), is(true));
        iterator.next();
        assertThat(iterator.hasNext(), is(true));
        iterator.next();
        assertThat(iterator.hasNext(), is(true));
        iterator.next();
        assertThat(iterator.hasNext(), is(true));
        iterator.next();
        assertThat(iterator.hasNext(), is(false));
        assertThat(iterator.hasNext(), is(false));
        }
    }

