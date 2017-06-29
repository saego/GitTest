import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *Created by Saego on 29.06.2017.
 */
public class SimpleListTest {
    private SimpleList<Person> list = new SimpleList<Person>();
    @org.junit.Test
    public void add() throws Exception {
        list.add(new Person("Tom", 57));
        list.add(new Person("Johnathan", 12));
        assertThat(list.get(0), is(new Person("Tom", 57)));
    }

    @org.junit.Test
    public void remove() throws Exception {
        list.add(new Person("Tom", 57));
        list.add(new Person("Johnathan", 12));
        list.add(new Person("Vivian", 33));
        int rmvPos = 0;
        list.remove(rmvPos);
        assertThat(list.get(0), is(new Person("Johnathan", 12)));
    }

    @org.junit.Test
    public void set() throws Exception {
        list.add(new Person("Tom", 57));
        list.add(new Person("Johnathan", 12));
        list.add(new Person("Vivian", 33));
        list.set(new Person("Johnathan", 12), new Person("Johnathan", 2));
        int setPos = 2;
        list.set(setPos, new Person("James", 18));
        assertThat(list.get(2), is(new Person("James", 18)));
        assertThat(list.get(1), is(new Person("Johnathan", 2)));
    }

    @org.junit.Test
    public void get() throws Exception {
        list.add(new Person("Tom", 57));
        assertThat(list.get(0), is(new Person("Tom", 57)));
    }

}