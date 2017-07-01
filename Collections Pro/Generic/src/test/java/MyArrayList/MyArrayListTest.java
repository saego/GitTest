package MyArrayList;

import SimpleList.Person;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 Created by Saego on 01.07.2017.
 */
public class MyArrayListTest {
    private MyArrayList<Person> persons = new MyArrayList<Person>();
    private MyArrayList<Person> testPersons = new MyArrayList<Person>(5);

    @Before
    public void testArrayFill(){
        this.testPersons.add(new Person("Johnathan", 12));
        this.testPersons.add(new Person("Roger", 21));
        this.testPersons.add(new Person("Mia", 34));
        this.testPersons.add(new Person("Tomas", 45));
        this.testPersons.add(new Person("Hanna", 4));
    }

    @Test
    public void add() throws Exception {
        List<Person> list = new ArrayList<Person>(5);
        list.add(new Person("Johnathan", 12));
        list.add(new Person("Roger", 21));
        list.add(new Person("Mia", 34));
        list.add(new Person("Tomas", 45));
        list.add(new Person("Hanna", 4));
        this.persons.add(new Person("Roger", 21));
        this.persons.add(new Person("Mia", 34));
        this.persons.add(new Person("Tomas", 45));
        this.persons.add(new Person("Hanna", 4));
        this.persons.add(0, new Person("Johnathan", 12));

        assertThat(this.persons.getAllElements(), is(list.toArray()));
    }

    @Test
    public void get() throws Exception {
        this.persons.add(new Person("Johnathan", 12));
        this.persons.add(new Person("Roger", 21));
        this.persons.add(new Person("Mia", 34));
        this.persons.add(new Person("Tomas", 45));
        this.persons.add(new Person("Hanna", 4));

        assertThat(this.persons.get(0), is(new Person("Johnathan", 12)));
        assertThat(this.persons.get(3), is(new Person("Tomas", 45)));
    }

    @Test
    public void remove() throws Exception {
        this.persons.add(new Person("Johnathan", 12));
        this.persons.add(new Person("Roger", 21));
        this.persons.add(new Person("Mia", 34));
        this.persons.add(new Person("Meataxe", 28)); // this person for remove.
        this.persons.add(new Person("Tomas", 45));
        this.persons.remove(3);
        this.persons.add(new Person("Hanna", 4));

        assertThat(this.persons.getAllElements(), is(this.testPersons.getAllElements()));
    }

    @Test
    public void size() throws Exception {
        this.persons.add(new Person("Johnathan", 12));
        this.persons.add(new Person("Roger", 21));
        this.persons.add(new Person("Mia", 34));
        this.persons.add(new Person("Tomas", 45));
        this.persons.add(new Person("Hanna", 4));

        assertThat(this.persons.size(), is(5));
    }

    @Test
    public void iterator() throws Exception {
        this.persons.add(new Person("Johnathan", 12));
        this.persons.add(new Person("Roger", 21));
        this.persons.add(new Person("Mia", 34));
        for (Object person:
             this.persons.getAllElements()) {
            System.out.println(person);
        }
        System.out.println(Arrays.toString(this.persons.getAllElements()));

        Iterator<Person> iterator = this.persons.iterator();

        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(new Person("Johnathan", 12)));

        iterator.next();

        assertThat(iterator.next(), is(new Person("Mia", 34)));
        assertThat(iterator.hasNext(), is(false));
        assertThat(iterator.hasNext(), is(false));

    }

    @Test
    public void loopTest(){
        Person[] tmp = new Person[5];
        this.persons.add(new Person("Johnathan", 12));
        this.persons.add(new Person("Roger", 21));
        this.persons.add(new Person("Mia", 34));
        this.persons.add(new Person("Tomas", 45));
        this.persons.add(new Person("Hanna", 4));
        Iterator<Person> iterator = this.persons.iterator();
        int i = 0;
        while (iterator.hasNext()){
            tmp[i] = iterator.next();
            i++;
        }

        assertThat(tmp, is(this.testPersons.getAllElements()));
    }
}