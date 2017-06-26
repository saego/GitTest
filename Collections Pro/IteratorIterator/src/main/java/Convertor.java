import java.util.Iterator;

/**
 *Created by Saego on 26.06.2017.
 */
public class Convertor implements IterIter{
    public Iterator<Integer> convert(Iterator<Iterator<Integer>> iteratorIterator) {
        return new MyIterator(iteratorIterator);
    }

    private class MyIterator implements Iterator<Integer> {
        private final Iterator<Iterator<Integer>> allIterators;
        private final Iterator<Integer> thisIterator;
        /**
         * Constructor.
         * @param iteratorIterator - iterators.
         */
        MyIterator(Iterator<Iterator<Integer>> iteratorIterator) {
            this.allIterators = iteratorIterator;
            this.thisIterator = iteratorIterator.next();
        }

        public boolean hasNext() {
            return false;
        }

        public Integer next() {
            return null;
        }

        public void remove() {

        }
    }
}
