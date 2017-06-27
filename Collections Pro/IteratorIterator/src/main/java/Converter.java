import java.util.Iterator;

/**
 *Created by Saego on 26.06.2017.
 */
public class Converter implements IteratorOfIterator {
    public Iterator<Integer> convert(Iterator<Iterator<Integer>> iteratorIterator) {
        return new MyIterator(iteratorIterator);
    }

    private class MyIterator implements Iterator<Integer> {
        private final Iterator<Iterator<Integer>> allIterators;
        private Iterator<Integer> thisIterator;
        /**
         * Constructor.
         * @param iteratorIterator - all iterators.
         */
        MyIterator(Iterator<Iterator<Integer>> iteratorIterator) {
            this.allIterators = iteratorIterator;
            this.thisIterator = iteratorIterator.next();
        }

        /**
         * If has next in all iterators.
         * @return - next value, don't move cursor.
         */
        public boolean hasNext() {
            return this.thisIterator.hasNext() || this.allIterators.hasNext();
        }

        /**
         * Next value from all iterators.
         * @return - next, move cursor.
         */
        public Integer next() {
            if (!this.thisIterator.hasNext()){
                this.thisIterator = this.allIterators.next();
            }
            return this.thisIterator.next();
        }

        public void remove() {

        }
    }
}
