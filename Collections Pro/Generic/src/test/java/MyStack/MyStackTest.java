package MyStack;

import SimpleList.Person;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Saego on 11.07.2017.
 */
public class MyStackTest {
    private MyStack <Person> persons = new MyStack<Person>();
    private MyStack<Person> testPersons = new MyStack<Person>();

    @Before
    public void initialization(){
        this.testPersons.push(new Person("Irena", 18));
        this.testPersons.push(new Person("Johnathan", 4));
        this.testPersons.push(new Person("Hanna", 26));
        this.testPersons.push(new Person("Jack", 32));
        this.testPersons.push(new Person("Bob", 8));
    }
    @Test
    public void push() throws Exception {
        persons
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