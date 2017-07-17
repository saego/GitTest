package MyQueue;

import SimpleList.Person;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *Created by Saego on 13.07.2017.
 */
public class MyQueueTest {
    private MyQueue<Person> personsTest = new MyQueue<Person>();
    private Person[] arrayPersons;
    @Before
    public void setUp() throws Exception {
        this.personsTest.push(new Person("Nik", 14));
        this.personsTest.push(new Person("Johnathan", 3));
        this.personsTest.push(new Person("Olivia", 21));
        this.personsTest.push(new Person("Sonja", 17));
        this.personsTest.push(new Person("Reginald", 35));
        this.arrayPersons = new Person[]{
                new Person("Nik", 14),
                new Person("Johnathan", 3),
                new Person("Olivia", 21),
                new Person("Sonja", 17),
                new Person("Reginald", 35),
        };
    }

    @Test
    public void push() throws Exception {
        Person[] arrayTestPersons = new Person[5];
        int i =0;
        for (Person person:
             this.personsTest) {
            arrayTestPersons[i] = person;
            i++;
        }
        assertThat(arrayTestPersons, is(this.arrayPersons));
    }

    @Test
    public void pop() throws Exception {
        try {
        assertThat(this.personsTest.pop(), is(new Person("Nik", 14)));
        assertThat(this.personsTest.pop(), is( new Person("Johnathan", 3)));
        assertThat(this.personsTest.pop(), is(new Person("Olivia", 21)));
        assertThat(this.personsTest.pop(),is(new Person("Sonja", 17)));
        assertThat(this.personsTest.pop(), is(new Person("Reginald", 35)));
        assertThat(this.personsTest.pop(), is(new Person("Reginald", 35)));
        }
        catch (NullPointerException ex){
            ex.printStackTrace();
        }
    }

    @Test
    public void peek() throws Exception {
        assertThat(this.personsTest.peek(), is(new Person("Nik", 14)));
    }

    @Test
    public void count() throws Exception {
        assertThat(this.personsTest.count(), is(5));
    }

    @Test
    public void iterator() throws Exception {
        Iterator<Person> personIterator = this.personsTest.iterator();
        Person[] array = new Person[5];
        int i = 0;
        while (personIterator.hasNext()){
            array[i] = personIterator.next();
            i++;
        }
        assertThat(array, is(this.arrayPersons));
    }

}