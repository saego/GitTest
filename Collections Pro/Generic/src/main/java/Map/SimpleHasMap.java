package Map;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

/**
 * Created by Saego on 09.08.2017.
 */
public class SimpleHasMap<T, V> implements SimpleMapIterable<T, V> {
    private final int BUCKET_CAPACITY = 16;
    private final float LOAD_FACTOR = (float) 0.75;
    private Bucket<T, V>[] bucketArray;
    private float loadFactor;

    SimpleHasMap() {
        this.bucketArray = (Bucket<T, V>[])new Bucket[BUCKET_CAPACITY];
        this.loadFactor = LOAD_FACTOR;
    }

    public SimpleHasMap(int capacity, float loadFactor) {
        this.bucketArray = (Bucket<T, V>[]) new Bucket[capacity];
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
            int bucket = getBucketNumber(simpleHash(key.hashCode()));
            if (this.bucketArray[bucket] != null & this.bucketArray[bucket].getKeyValue().equals(key)){
                value = this.bucketArray[bucket].getBucketValue();
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

    public class Bucket <TT, VV>{
        TT key;
        VV value;

        Bucket(TT key, VV value) {
            this.key = key;
            this.value = value;
        }

        TT getKeyValue() {
            return key;
        }

        VV getBucketValue() {
            return value;
        }
    }

    /*private class MapNode<TT, VV> {
        public TT key;
        public VV value;
        MapNode<TT, VV> next;

        public MapNode(TT key, VV value, MapNode<TT, VV> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public TT getKey() {
            return key;
        }

        public void setKey(TT key) {
            this.key = key;
        }

        public VV getValue() {
            return value;
        }

        public void setValue(VV value) {
            this.value = value;
        }

        public MapNode<TT, VV> getNext() {
            return next;
        }

        public void setNext(MapNode<TT, VV> next) {
            this.next = next;
        }
    }*/
}
