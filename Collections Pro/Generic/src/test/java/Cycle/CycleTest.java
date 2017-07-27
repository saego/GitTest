package Cycle;

import SimpleList.Person;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Saego on 27.07.2017.
 */
public class CycleTest {
    private SimpleNode<Person> person1 = new SimpleNode<Person>(null, new Person("Name1", 12));
    private SimpleNode<Person> person2 = new SimpleNode<Person>(null, new Person("Name2", 13));
    private SimpleNode<Person> person3 = new SimpleNode<Person>(null, new Person("Name3", 14));
    private SimpleNode<Person> person4 = new SimpleNode<Person>(null, new Person("Name4", 15));
    @Test
    public void loop() throws Exception {
        person1.next = person2;
        person2.next = person3;
        person3.next = person4;
        person4.next = person1;
        Cycle<Person> cycle = new Cycle<Person>();
        assertThat(cycle.loop(person1), is(true));
    }

}