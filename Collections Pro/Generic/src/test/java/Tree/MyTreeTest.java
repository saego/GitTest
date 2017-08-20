package Tree;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Saego on 20.08.2017.
 */
public class MyTreeTest {
    Integer i0 = 0, i1 = 34, i2 = 4, i3 = 16, i4 = 46, i5 = 13, i6 = 5;
    MyTree<Integer> tree = new MyTree<>();
    @Test
    public void add() throws Exception {
        tree.add(i0);
        tree.add(i1);
        tree.add(i2);
        tree.add(i3);
        tree.add(i4);
        tree.add(i5);
        tree.add(i6);
    }

    @Test
    public void iterator() throws Exception {
    }

}