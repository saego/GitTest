package MyStack;

import SimpleList.Person;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.Stack;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 *Created by Saego on 11.07.2017.
 */
public class MyStackTest {
    private MyStack <Person> persons = new MyStack<Person>();
    private MyStack<Person> testPersons = new MyStack<Person>();
    private Stack<Person> realStack = new Stack<Person>();

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
        this.persons.push(new Person("Irena", 18));
        this.persons.push(new Person("Johnathan", 4));
        this.persons.push(new Person("Hanna", 26));
        this.persons.push(new Person("Jack", 32));
        this.persons.push(new Person("Bob", 8));
        this.realStack.push(new Person("Irena", 18));
        this.realStack.push(new Person("Johnathan", 4));
        this.realStack.push(new Person("Hanna", 26));
        this.realStack.push(new Person("Jack", 32));
        this.realStack.push(new Person("Bob", 8));
        Person[] array1 = new Person[5];
        Person[] array2 = new Person[5];
        int i = 0;
        for (Person person:
             this.persons) {
            array1[i] = person;
            i++;
        }
        int k  = 0;
        for (Person stackPerson:
             this.realStack) {
            array2[k] = stackPerson;
            i++;
        }
        assertThat(array1, is(array2));
    }

    @Test
    public void pop() throws Exception {
        assertThat(this.testPersons.pop(), is(new Person("Bob", 8)));
    }

    @Test
    public void peek() throws Exception {
        try {
        assertThat(this.testPersons.pop(), is(new Person("Bob", 8)));
        assertThat(this.testPersons.peek(), is(new Person("Bob", 8)));
        assertThat(this.testPersons.pop(), is(new Person("Jack", 32)));
        assertThat(this.testPersons.peek(), is(new Person("Jack", 32)));
        assertThat(this.testPersons.peek(), is(new Person("Hanna", 26)));
        assertThat(this.testPersons.peek(), is(new Person("Johnathan", 4)));
        assertThat(this.testPersons.peek(), is(new Person("Irena", 18)));
            System.out.println(this.testPersons.peek());
        }
        catch (NullPointerException ex){
            ex.printStackTrace();
        }
    }

    @Test
    public void count() throws Exception {
        assertThat(this.testPersons.count(), is(5));
    }

    @Test
    public void iterator() throws Exception {
        Iterator<Person> iterator = this.testPersons.iterator();
        Iterator<Person> iterator1 = this.testPersons.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(new Person("Bob", 8)));
        iterator.next();
        //iterator.next();
        assertThat(iterator.next(), is(new Person("Hanna", 26)));
        iterator.next();
        iterator.next();
        assertThat(iterator.hasNext(), is(false));
        assertThat(iterator.hasNext(), is(false));
        Person[] persons = new Person[]{
                new Person("Bob", 8),
                new Person("Jack", 32),
                new Person("Hanna", 26),
                new Person("Johnathan", 4),
                new Person("Irena", 18),
        };
        Person[] persons1 = new Person[5];
        int n = 0;
        while (iterator1.hasNext()){
            persons1[n] = iterator1.next();
            n++;
        }
        assertThat(persons1, is(persons));
    }

}