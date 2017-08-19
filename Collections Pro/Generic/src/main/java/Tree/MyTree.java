package Tree;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

/**
 * Created by Saego on 19.08.2017.
 */
public class MyTree<T extends Comparable<T>> implements SimpleTree {
    @Override
    public boolean add(Comparable parent, Comparable child) {
        return false;
    }

    @NotNull
    @Override
    public Iterator iterator() {
        return null;
    }
}
