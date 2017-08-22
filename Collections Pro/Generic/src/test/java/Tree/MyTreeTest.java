package Tree;

import org.junit.Test;

import java.util.Iterator;
import java.util.TreeSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Saego on 20.08.2017.
 */
public class MyTreeTest {
    private Integer i0 = 6, i1 = 34, i2 = 4, i3 = 16, i4 = 46, i5 = 13, i6 = 5, i7 = 33;
    private MyTree<Integer> tree = new MyTree<>();
    @Test
    public void add() throws Exception {
        tree.add(i0);
        tree.add(i1);
        tree.add(i2);
        tree.add(i3);
        tree.add(i4);
        tree.add(i5);
        tree.add(i6);
        tree.add(i7);
    }

    @Test
    public void iterator() throws Exception {

    }

    @Test
    public void getLeaf() throws Exception {
        tree.add(i0);
        tree.add(i1);
        tree.add(i2);
        tree.add(i3);
        tree.add(i4);
        tree.add(i5);
        tree.add(i6);
        tree.add(i7);
        assertThat(tree.getLeaf(i4), is(46));
        assertThat(tree.getLeaf(i3), is(16));
        assertThat(tree.getLeaf(i2), is(4));
        assertThat(tree.getLeaf(i1), is(34));
        assertThat(tree.getLeaf(i0), is(6));
        assertThat(tree.getLeaf(i5), is(13));
        assertThat(tree.getLeaf(i6), is(5));
        assertThat(tree.getLeaf(i7), is(33));
        try {
        assertThat(tree.getLeaf(18), is(46));
            System.out.println(tree.getLeaf(33));
        }
        catch (NullPointerException npEx){
            npEx.printStackTrace();
        }
    }

    @Test
    public void testTree(){
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(i0);
        treeSet.add(i1);
        treeSet.add(i2);
        treeSet.add(i3);
        treeSet.add(i4);
        treeSet.add(i5);
        treeSet.add(i6);
        Iterator<Integer> iterator = treeSet.iterator();
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
    }
}