package MyLinkedList;

import SimpleList.Person;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 Created by Saego on 03.07.2017.
 */
public class MyLinkedListTest {
    private MyLinkedList<Person> persons = new MyLinkedList<Person>();
    private MyLinkedList<Person> listAssert = new MyLinkedList<Person>();
    private List<Person> testPersons = new LinkedList<Person>();
    @Before
    public void setUp() throws Exception {
        this.listAssert.add(new Person("Lisa", 30));
        this.listAssert.add(new Person("Johnathan", 11));
        this.listAssert.add(new Person("Kidd", 33));
        this.listAssert.add(new Person("Penelopa", 14));
        this.testPersons.add(new Person("Lisa", 30));
        this.testPersons.add(new Person("Johnathan", 11));
        this.testPersons.add(new Person("Kidd", 33));
        this.testPersons.add(new Person("Penelopa", 14));
    }

    @Test
    public void add() throws Exception {
        this.persons.add(new Person("Lisa", 30));
        this.persons.add(new Person("Johnathan", 11));
        this.persons.add(new Person("Kidd", 33));
        this.persons.add(new Person("Penelopa", 14));
        Person[] toArray = new Person[4];
        int i = 0;
        for (Person person:
             this.persons) {
            toArray[i] = person;
            i++;
        }
        assertThat(toArray, is(this.testPersons.toArray()));
    }

    @Test
    public void addByPosition() throws Exception {
        this.persons.add(new Person("Lisa", 30));
        this.persons.add(new Person("Kidd", 33));
        this.persons.add(new Person("Penelopa", 14));
        this.persons.add(1, new Person("Johnathan", 11));
        Person[] toArray = new Person[4];
        int i = 0;
        for (Person person:
                this.persons) {
            toArray[i] = person;
            i++;
        }
        assertThat(toArray, is(this.testPersons.toArray()));
    }

    @Test
    public void get() throws Exception {
        this.persons.add(new Person("Lisa", 30));
        this.persons.add(new Person("Johnathan", 11));
        this.persons.add(new Person("Kidd", 33));
        this.persons.add(new Person("Penelopa", 14));
        assertThat(this.persons.get(0), is(new Person("Lisa", 30)));
        assertThat(this.persons.get(2), is(new Person("Kidd", 33)));
        try {
        this.persons.get(5);
        }
        catch (NullPointerException ex){
            ex.printStackTrace();
        }
    }

    @Test
    public void remove() throws Exception {
    }

    @Test
    public void size() throws Exception {
        this.persons.add(new Person("Lisa", 30));
        this.persons.add(new Person("Johnathan", 11));
        this.persons.add(new Person("Kidd", 33));
        this.persons.add(new Person("Penelopa", 14));
        assertThat(this.persons.size(), is(4));
    }

    @Test
    public void iterator() throws Exception {
        Iterator<Person> iterator = this.listAssert.iterator();
        assertThat(iterator.hasNext(), is(true));
        iterator.next();
        iterator.next();
        iterator.next();
        assertThat(iterator.hasNext(), is(true));
        iterator.next();
        assertThat(iterator.hasNext(), is(false));
        assertThat(iterator.hasNext(), is(false));
        System.out.println("-----------------");
        for (Person person:
             this.listAssert) {
            System.out.println(person);
        }
        System.out.println("-----------------");
        System.out.println(this.listAssert);
        System.out.println("-----------------");
    }

}