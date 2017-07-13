package MyQueue;

import SimpleList.Person;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *Created by Saego on 13.07.2017.
 */
public class MyQueueTest {
    MyQueue<Person> personsTest = new MyQueue<Person>();
    @Before
    public void setUp() throws Exception {
        this.personsTest.push();
    }

    @Test
    public void push() throws Exception {
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