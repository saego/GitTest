package MyArrayList;

import java.util.Iterator;

/**
 *Created by Saego on 30.06.2017.
 */
public class MyArrayList<T> implements MyIterator<T>{
    private static final int ARRAY_CAPACITY = 10;
    private Object[]elements;
    int index = 0;

    /**
     * Default constructor.
     */
    public MyArrayList() {
        this.elements = new Object[ARRAY_CAPACITY];
    }

    /**
     * Custom constructor.
     * @param initialCapacity - initial size of arrayList.
     */
    public MyArrayList(int initialCapacity){
    this.elements = new Object[initialCapacity];
    }

}
