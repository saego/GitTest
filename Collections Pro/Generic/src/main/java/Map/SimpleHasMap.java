package Map;

import org.jetbrains.annotations.Contract;
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
    private int quantity = 0;

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
            if (isOverload()){
                quantity = 0;
                resize();
            }
            int bucket = getBucketNumber(simpleHash(key.hashCode()));
            if (bucketArray[bucket] == null){
                bucketArray[bucket] = new Bucket<T, V>(key, value, null, null);
                resultOperation = true;
                quantity ++;
            }
            else {
                Bucket<T, V> tmpBucket = bucketArray[bucket];
                bucketArray[bucket] = new Bucket<T, V>(key, value, bucketArray[bucket], null);
                tmpBucket.prev = bucketArray[bucket];
                resultOperation = true;
                quantity ++;
            }
        }
        return resultOperation;
    }

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

    @Contract(pure = true)
    private boolean isOverload() {
        return (float)(this.quantity + 1) / this.bucketArray.length >= this.loadFactor;
    }

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
                    tmpBuck.getPrevBucketQ().next = tmpBuck.getNextBucketQ();
                    result = true;
                    break;
                }
                else tmpBuck = tmpBuck.getNextBucketQ();
            }
            while (tmpBuck != null);
        }
        return result;
    }

    @NotNull
    public Iterator<T> iterator() {
        return null;
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
}
