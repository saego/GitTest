package MyQueue;

import SimpleList.Person;
import org.junit.Before;
import org.junit.Test;

import java.util.Queue;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *Created by Saego on 13.07.2017.
 */
public class MyQueueTest {
    private MyQueue<Person> personsTest = new MyQueue<Person>();
    @Before
    public void setUp() throws Exception {
        this.personsTest.push(new Person("Nik", 14));
        this.personsTest.push(new Person("Johnathan", 3));
        this.personsTest.push(new Person("Olivia", 21));
        this.personsTest.push(new Person("Sonja", 17));
        this.personsTest.push(new Person("Reginald", 35));
    }

    @Test
    public void push() throws Exception {
        Person[] arrayPersons = new Person[]{
                new Person("Nik", 14),
                new Person("Johnathan", 3),
                new Person("Olivia", 21),
                new Person("Sonja", 17),
                new Person("Reginald", 35),
        };
        Person[] arrayTestPersons = new Person[5];
        int i =0;
        for (Person person:
             this.personsTest) {
            arrayTestPersons[i] = person;
            i++;
        }
        assertThat(arrayTestPersons, is(arrayPersons));
    }

    @Test
    public void pop() throws Exception {
    }

    @Test
    public void peek() throws Exception {
    }

    @Test
    public void count() throws Exception {
    }

    @Test
    public void iterator() throws Exception {
    }

}