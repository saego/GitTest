package Map;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

/**
 * Created by Saego on 09.08.2017.
 */
public class SimpleHasMap<T, V> implements SimpleMapIterable<T, V> {
    private final int BUCKET_CAPACITY = 16;
    private final float LOAD_FACTOR = (float) 0.75;
    private Object[] bucketArray;
    private float loadFactor;

    public SimpleHasMap() {
        this.bucketArray = new Object[BUCKET_CAPACITY];
        this.loadFactor = LOAD_FACTOR;
    }

    public SimpleHasMap(int capacity, float loadFactor) {
        this.bucketArray = new Object[capacity];
        this.loadFactor = loadFactor;
    }

    public boolean put(T key, V value) {
        boolean resultOperation = false;
        if (key != null){
            int bucket = getBucketNumber(simpleHash(key.hashCode()));
            if (bucketArray[bucket] == null){
                bucketArray[bucket] = new Bucket<T, V>(key, value);
                resultOperation = true;
            }
        }
        return resultOperation;
    }

    private int simpleHash(int code) {
        return code ^ (code >>> 16);
    }

    private int getBucketNumber(int hash){
        return hash & (this.bucketArray.length - 1);
    }

    public V getValue(T key) {
        V value = null;
        if (key != null){
            for (Object bucket:
                 this.bucketArray) {
                if (bucket.ge)
            }
        }
        return value;
    }

    public boolean removeNode(T key) {
        return false;
    }

    @NotNull
    public Iterator<T> iterator() {
        return null;
    }

    private class Bucket <T, V>{
        T key;
        V value;

        Bucket(T key, V value) {
            this.key = key;
            this.value = value;
        }

        public T getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    /*private class MapNode<T, V> {
        public T key;
        public V value;
        MapNode<T, V> next;

        public MapNode(T key, V value, MapNode<T, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public T getKey() {
            return key;
        }

        public void setKey(T key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public MapNode<T, V> getNext() {
            return next;
        }

        public void setNext(MapNode<T, V> next) {
            this.next = next;
        }
    }*/
}
