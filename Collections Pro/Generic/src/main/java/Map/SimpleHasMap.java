package Map;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

/**
 * Created by Saego on 09.08.2017.
 */
public class SimpleHasMap<T, V> implements SimpleMapIterable<T, V> {
    private Bucket<T, V>[] bucketArray;
    private float loadFactor;
    private int quantity = 0;

    /**
     * Default constructor.
     */
    SimpleHasMap() {
        int BUCKET_CAPACITY = 16;
        this.bucketArray = (Bucket<T, V>[])new Bucket[BUCKET_CAPACITY];
        this.loadFactor = (float) 0.75;
    }

    /**
     * Custom constructor.
     * @param capacity - start quantity of buckets.
     * @param loadFactor - max load of buckets, if more - quantity of bucket increase.
     */
    SimpleHasMap(int capacity, float loadFactor) {
        this.bucketArray = (Bucket<T, V>[]) new Bucket[capacity];
        this.loadFactor = loadFactor;
    }

    /**
     * Add new element to hash table.
     * @param key - key of element.
     * @param value - value of element.
     * @return - true - if element has been added to table.
     */
    public boolean put(T key, V value) {
        boolean resultOperation = false;
        if (key != null){
            if (isOverload()){
                quantity = 0;
                resize();
            }
            int bucket = getBucketNumber(simpleHash(key.hashCode()));
            if (bucketArray[bucket] == null){
                bucketArray[bucket] = new Bucket<>(key, value, null, null);
                resultOperation = true;
                quantity ++;
            }
            else {
                Bucket<T, V> tmpBucket = bucketArray[bucket];
                bucketArray[bucket] = new Bucket<>(key, value, bucketArray[bucket], null);
                tmpBucket.prev = bucketArray[bucket];
                resultOperation = true;
                quantity ++;
            }
        }
        return resultOperation;
    }

    /**
     * Increase hash table size, if current load_factor is bigger than in constructor.
     */
    private void resize() {
        Bucket<T, V>[] tmpArray = (Bucket<T, V>[]) new Bucket[this.bucketArray.length];
        System.arraycopy(this.bucketArray, 0, tmpArray, 0, this.bucketArray.length);
        this.bucketArray = (Bucket<T, V>[]) new Bucket[this.bucketArray.length * 2];
        for (Bucket<T, V> buck:
             tmpArray) {
            if (buck != null){
                Bucket<T, V> tmpBuck = buck;
                do {
                    T key = tmpBuck.getKeyValue();
                    V value = tmpBuck.getBucketValue();
                    put(key, value);
                    tmpBuck = tmpBuck.getNextBucketQ();
                    }
                while (tmpBuck != null);
            }
        }
    }

    /**
     * Check if current load_factor is bigger than in constructor.
     * @return - true - if current load_factor is bigger than in constructor.
     */
    @Contract(pure = true)
    private boolean isOverload() {
        return (float)(this.quantity + 1) / this.bucketArray.length >= this.loadFactor;
    }

    /**
     *
     * @param code
     * @return
     */
    @Contract(pure = true)
    private int simpleHash(int code) {
        return code ^ (code >>> 16);
    }

    @Contract(pure = true)
    private int getBucketNumber(int hash){
        return hash & (this.bucketArray.length - 1);
    }

    public V getValue(T key) {
        V value = null;
        if (key != null){
            int bucket = getBucketNumber(simpleHash(key.hashCode()));
            if (this.bucketArray[bucket] != null){
                Bucket<T, V> tmpBuck = this.bucketArray[bucket];
                do {
                    if (tmpBuck.getKeyValue().equals(key)){
                        value = this.bucketArray[bucket].getBucketValue();
                        break;
                    }
                    else tmpBuck = tmpBuck.getNextBucketQ();
                }
                while (tmpBuck != null);
            }
        }
        return value;
    }

    public boolean removeNode(T key) {
        int bucket = getBucketNumber(simpleHash(key.hashCode()));
        boolean result = false;
        if (this.bucketArray[bucket] != null){
            Bucket<T, V> tmpBuck = this.bucketArray[bucket];
            do {
                if (tmpBuck.getKeyValue().equals(key)){
                    if ((tmpBuck.getPrevBucketQ() == null) & (tmpBuck.getNextBucketQ() == null)){
                        this.bucketArray[bucket] = null;
                        result = true;
                        break;
                    }
                    else if ((tmpBuck.getPrevBucketQ() == null) & (tmpBuck.getNextBucketQ() != null)){
                        this.bucketArray[bucket] = tmpBuck.getNextBucketQ();
                        tmpBuck.getNextBucketQ().prev = null;
                        result = true;
                        break;
                    }
                    else if ((tmpBuck.getPrevBucketQ() != null) & (tmpBuck.getNextBucketQ() == null)){
                        tmpBuck.getPrevBucketQ().next = null;
                        result = true;
                        break;
                    }
                    else {
                        tmpBuck.getPrevBucketQ().next = tmpBuck.getNextBucketQ();
                        result = true;
                        break;
                    }
                }
                else tmpBuck = tmpBuck.getNextBucketQ();
            }
            while (tmpBuck != null);
        }
        return result;
    }

    private Bucket<T, V>[] bucketsWithoutNull(Bucket<T, V>[] buckets){
        int notNullQuantity = 0;
        int iteratorNotNull = 0;
        for (Bucket<T, V> bucket : buckets) {
            if (bucket != null) {
                notNullQuantity++;
            }
        }
        Bucket<T, V>[] notNullBucket = (Bucket<T, V>[])new Bucket[notNullQuantity];
        for (Bucket<T, V> bucket :
                buckets) {
            if (bucket != null) {
                notNullBucket[iteratorNotNull] = bucket;
                iteratorNotNull++;
            }
        }
        return notNullBucket;
    }

    @NotNull
    public Iterator<T> iterator() {
        return new MyMapIterator<>(bucketsWithoutNull(this.bucketArray));
    }

    private class Bucket<TT, VV> {
        TT key;
        public VV value;
        Bucket<TT, VV> next;
        Bucket<TT, VV> prev;

        Bucket(TT key, VV value, Bucket<TT, VV> next, Bucket<TT, VV> prev) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        TT getKeyValue() {
            return this.key;
        }

        VV getBucketValue() {
            return this.value;
        }

        Bucket<TT, VV> getNextBucketQ() {
            return this.next;
        }

        Bucket<TT, VV> getPrevBucketQ(){
            return  this.prev;
        }
    }

    private class MyMapIterator<TT> implements Iterator<TT> {
        Bucket<TT, V>[] buckets;
        int iterator = 0;
        Bucket<TT, V> currentBucket = null;
        MyMapIterator(Bucket<TT, V>[] bucketArray) {
            buckets = bucketArray;
        }

        @Override
        public boolean hasNext() {
            boolean has = false;
            Bucket<TT, V> tmpBucket = this.currentBucket;
            if (this.iterator < this.buckets.length) {
                if ((tmpBucket == null) & (this.buckets.length != 0)){
                    has = true;
                }
                else {
                    assert tmpBucket != null;
                    if ((tmpBucket.getNextBucketQ() != null) || ((this.iterator + 1) != this.buckets.length)){
                        has = true;
                    }
                }
            }
            return has;
        }

        @Override
        public TT next() {
            TT returnBucket;
            if (this.currentBucket == null){
                this.currentBucket = this.buckets[iterator];
                returnBucket = this.currentBucket.getKeyValue();
            }
            else {
                returnBucket = this.currentBucket.getKeyValue();
            }
            if (this.currentBucket.getNextBucketQ() == null){
                this.iterator++;
                this.currentBucket = null;
            }
            else {
                this.currentBucket = this.currentBucket.getNextBucketQ();
            }
            return returnBucket;
        }

        @Override
        public void remove() {
        }
    }
}
