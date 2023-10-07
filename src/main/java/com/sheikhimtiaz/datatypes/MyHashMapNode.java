package com.sheikhimtiaz.datatypes;

public class MyHashMapNode<K, V> {

    private K key;
    private V value;
    private MyHashMapNode<K, V> next;
    private long hashCode;

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public MyHashMapNode<K, V> getNext() {
        return next;
    }

    public void setNext(MyHashMapNode<K, V> next) {
        this.next = next;
    }

    public long getHashCode() {
        return hashCode;
    }

    public void setHashCode(long hashCode) {
        this.hashCode = hashCode;
    }
}
