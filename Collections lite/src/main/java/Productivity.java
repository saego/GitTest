import java.util.Collection;
import java.util.Iterator;

import static java.lang.Math.pow;

/**
 *Created by Saego on 07.06.2017.
 */
class Productivity {
    private static final String TEXT = "element";
    private long beginTime, endTime;
    /**
     *
      * @param collection - collection to test.
     * @param amount - quantity of adds.
     * @return - time of operation.
     */
    long addElement(Collection<String> collection, int amount){
        beginTime  = System.nanoTime();
        for (int i = 0; i < amount; i++){
            collection.add(TEXT + i);
        }
        endTime = System.nanoTime();
        return (long) ((endTime - beginTime) /pow(10, 6));
    }

    /**
     *
      * @param collection - collection to test.
     * @param amount - quantity of removes.
     * @return - time of operation.
     */
    long removeElement(Collection<String> collection, int amount){
        Iterator<String> iterator = collection.iterator();
        beginTime = System.currentTimeMillis();
        for (int i = 0; i < amount; i++){
            if (iterator.hasNext()) {
                iterator.next();
                iterator.remove();
            }
        }
        endTime = System.currentTimeMillis();
        return (long) ((endTime - beginTime) / pow(10, 6));
    }
}
