package Set;

import SimpleList.Person;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Saego on 31.07.2017.
 */
public class SimpleLinkedSetTest {
        private SimpleLinkedSet<Person> persons = new SimpleLinkedSet<Person>();
        private Person person1 = new Person("Johnathan", 7);
        private Person person2 = new Person("Emile", 21);
        private Person person3 = new Person("Nick", 15);
        private Person person4 = new Person("Sandy", 19);
        private Person person5 = new Person("Johnathan", 7);
        private Person person6 = new Person("Peter", 32);
        private Person[] personsArray;
    @Before
    public void setUp() throws Exception {
        this.persons.add(person1);
        this.persons.add(person2);
        this.persons.add(person3);
        this.persons.add(person4);
        this.persons.add(person5);
        this.persons.add(person6);
        this.personsArray = new Person[]{person1, person2, person3, person4, person6};
    }

    @Test
    public void add() throws Exception {
        Person[] testPersonsArray = new Person[5];
        int i= 0;
        for (Person person:
             this.persons) {
            testPersonsArray[i] = person;
            i++;
        }
        assertThat(testPersonsArray, is(personsArray));
    }

    @Test
    public void size() throws Exception {
        assertThat(this.persons.size(), is(5));
    }

    @Test
    public void iterator() throws Exception {
        Iterator<Person> iterator = this.persons.iterator();
        assertThat(iterator.next(), is(new Person("Johnathan", 7)));
        assertThat(iterator.hasNext(), is(true));
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
        assertThat(iterator.hasNext(), is(false));
        assertThat(iterator.hasNext(), is(false));
    }

}